package ru.spring.orlov.serviceImpl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.spring.orlov.dao.QuestionnaireDao;
import ru.spring.orlov.daoSimpl.QuestionnaireDaoCSV;
import ru.spring.orlov.model.Questionnaire;
import ru.spring.orlov.service.QuestionnaireService;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@DisplayName("Class QuestionAndAnswerServiceImpl")
@ExtendWith(MockitoExtension.class)
class QuestionnaireServiceImplTest {

    private static final String FIELD_NAME = "resultTestings.csv";

    private List<Questionnaire> answerList;

    private QuestionnaireService subj;

    private QuestionnaireDao questionnaireDao;

    @BeforeEach
    void setUp() {
        answerList = Arrays.asList(
                new Questionnaire("Do you have any development experience", "yes"),
                new Questionnaire("Are you over 30 years old", "yes"),
                new Questionnaire("Do you have a higher education", "yes"),
                new Questionnaire("Do you live in Russia", "yes"),
                new Questionnaire("Were you born in Russia", "no"));
        questionnaireDao = mock(QuestionnaireDaoCSV.class);
        subj = new QuestionnaireServiceImpl(questionnaireDao);
    }

    @Test
    @DisplayName("Test verification, we get the correct fields")
    void findByQuestionAndAnswerSuccessfulTest() {
        when(questionnaireDao.getQuestions()).thenReturn(answerList);

        List<Questionnaire> questionnaireList = subj.getQuestions();
        assertEquals(answerList, questionnaireList);
        assertEquals(answerList.size(), questionnaireList.size());

        assertEquals(questionnaireList.get(0).getQuestion(), "Do you have any development experience");
        assertEquals(questionnaireList.get(1).getQuestion(), "Are you over 30 years old");
        assertEquals(questionnaireList.get(2).getQuestion(), "Do you have a higher education");
        assertEquals(questionnaireList.get(3).getQuestion(), "Do you live in Russia");
        assertEquals(questionnaireList.get(4).getQuestion(), "Were you born in Russia");

        assertNotNull(questionnaireList.get(0).getAnswer());
        assertNotNull(questionnaireList.get(1).getAnswer());
        assertNotNull(questionnaireList.get(2).getAnswer());
        assertNotNull(questionnaireList.get(3).getAnswer());
        assertNotNull(questionnaireList.get(4).getAnswer());
    }

    @Test
    @DisplayName("Test check, we get incorrect fields")
    void findByQuestionAndAnswerNotSuccessfulTest() {
        when(questionnaireDao.getQuestions()).thenReturn(answerList);

        List<Questionnaire> questionnaireList = subj.getQuestions();
        assertNotEquals(questionnaireList.get(0).getQuestion(), "Do you have any development experience888");
        assertNotEquals(questionnaireList.get(1).getQuestion(), "Are you over 30 years old888");
        assertNotEquals(questionnaireList.get(2).getQuestion(), "Do you have a higher education888");
        assertNotEquals(questionnaireList.get(3).getQuestion(), "Do you live in Russia888");
        assertNotEquals(questionnaireList.get(4).getQuestion(), "Were you born in Russia888");

        assertNotNull(questionnaireList.get(0).getAnswer());
        assertNotNull(questionnaireList.get(1).getAnswer());
        assertNotNull(questionnaireList.get(2).getAnswer());
        assertNotNull(questionnaireList.get(3).getAnswer());
        assertNotNull(questionnaireList.get(4).getAnswer());
    }
}