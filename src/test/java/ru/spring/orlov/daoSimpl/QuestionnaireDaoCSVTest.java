package ru.spring.orlov.daoSimpl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.spring.orlov.dao.QuestionnaireDao;
import ru.spring.orlov.model.Questionnaire;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@DisplayName("Class QuestionAndAnswerDaoSimple")
@ExtendWith(MockitoExtension.class)
class QuestionnaireDaoCSVTest {

    private QuestionnaireDao questionnaireDao;

    @BeforeEach
    void setUp() {
        questionnaireDao = mock(QuestionnaireDaoCSV.class);
    }

    @Test
    @DisplayName("Test verification, we get the correct fields")
    void findByQuestionAndAnswerSuccessful() {
        List<Questionnaire> answerList = Arrays.asList(
                new Questionnaire("Your age", "36"),
                new Questionnaire("Country of residence", "Russia"),
                new Questionnaire("City of residence", "Samara"),
                new Questionnaire("Higher education", "yes"),
                new Questionnaire("Your profession", "IT"));
        when(questionnaireDao.findByQuestionAndAnswer()).thenReturn(answerList);
        List<Questionnaire> questionnaireList = questionnaireDao.findByQuestionAndAnswer();
        assertNotEquals(questionnaireList.size(), 0);
        assertEquals(questionnaireList.get(0).getQuestion(), "Your age");
        assertEquals(questionnaireList.get(1).getQuestion(), "Country of residence");
        assertEquals(questionnaireList.get(2).getQuestion(), "City of residence");
        assertEquals(questionnaireList.get(3).getQuestion(), "Higher education");
        assertEquals(questionnaireList.get(4).getQuestion(), "Your profession");

        assertNotNull(questionnaireList.get(0).getAnswer());
        assertNotNull(questionnaireList.get(1).getAnswer());
        assertNotNull(questionnaireList.get(2).getAnswer());
        assertNotNull(questionnaireList.get(3).getAnswer());
        assertNotNull(questionnaireList.get(4).getAnswer());
    }

    @Test
    @DisplayName("Test check, we get incorrect fields")
    void findByQuestionAndAnswerNotSuccessful() {
        List<Questionnaire> answerList = Arrays.asList(
                new Questionnaire("Your age", "36"),
                new Questionnaire("Country of residence", "Russia"),
                new Questionnaire("City of residence", "Samara"),
                new Questionnaire("Higher education", "yes"),
                new Questionnaire("Your profession", "IT"));
        when(questionnaireDao.findByQuestionAndAnswer()).thenReturn(answerList);
        List<Questionnaire> questionnaireList = questionnaireDao.findByQuestionAndAnswer();
        assertNotEquals(questionnaireList.size(), 888);
        assertNotEquals(questionnaireList.get(0).getQuestion(), "Your age888");
        assertNotEquals(questionnaireList.get(1).getQuestion(), "Country of residence888");
        assertNotEquals(questionnaireList.get(2).getQuestion(), "City of residence888");
        assertNotEquals(questionnaireList.get(3).getQuestion(), "Higher education888");
        assertNotEquals(questionnaireList.get(4).getQuestion(), "Your profession888");

        assertNotNull(questionnaireList.get(0).getAnswer());
        assertNotNull(questionnaireList.get(1).getAnswer());
        assertNotNull(questionnaireList.get(2).getAnswer());
        assertNotNull(questionnaireList.get(3).getAnswer());
        assertNotNull(questionnaireList.get(4).getAnswer());
    }
}