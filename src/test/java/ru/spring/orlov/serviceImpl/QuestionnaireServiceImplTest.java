package ru.spring.orlov.serviceImpl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import ru.spring.orlov.dao.QuestionnaireDao;
import ru.spring.orlov.daoSimpl.QuestionnaireDaoSimple;
import ru.spring.orlov.model.Questionnaire;
import ru.spring.orlov.service.QuestionnaireService;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@DisplayName("Class QuestionAndAnswerServiceImpl")
@RunWith(MockitoJUnitRunner.class)
class QuestionnaireServiceImplTest {

    private QuestionnaireService subj;

    private QuestionnaireDao questionnaireDao;

    @BeforeEach
    void setUp() {
        questionnaireDao = mock(QuestionnaireDaoSimple.class);
        subj = new QuestionnaireServiceImpl(questionnaireDao);
    }

    @Test
    @DisplayName("Test verification, we get the correct fields")
    void findByQuestionAndAnswerSuccessful() {
        List<Questionnaire> answerList = Arrays.asList(
                new Questionnaire("Your age"),
                new Questionnaire("Country of residence"),
                new Questionnaire("City of residence"),
                new Questionnaire("Higher education"),
                new Questionnaire("Your profession"));
        when(questionnaireDao.findByQuestionAndAnswer()).thenReturn(answerList);

        List<Questionnaire> questionnaireList = subj.findByQuestionAndAnswer();
        assertEquals(answerList, questionnaireList);
        assertEquals(answerList.size(), questionnaireList.size());

        assertEquals(questionnaireList.get(0).getQuestion(), "Your age");
        assertEquals(questionnaireList.get(1).getQuestion(), "Country of residence");
        assertEquals(questionnaireList.get(2).getQuestion(), "City of residence");
        assertEquals(questionnaireList.get(3).getQuestion(), "Higher education");
        assertEquals(questionnaireList.get(4).getQuestion(), "Your profession");
    }

    @Test
    @DisplayName("Test check, we get incorrect fields")
    void findByQuestionAndAnswerNotSuccessful() {
        List<Questionnaire> answerList = Arrays.asList(
                new Questionnaire("Your age"),
                new Questionnaire("Country of residence"),
                new Questionnaire("City of residence"),
                new Questionnaire("Higher education"),
                new Questionnaire("Your profession"));
        when(questionnaireDao.findByQuestionAndAnswer()).thenReturn(answerList);

        List<Questionnaire> questionnaireList = subj.findByQuestionAndAnswer();
        assertNotEquals(questionnaireList.get(0).getQuestion(), "Your age888");
        assertNotEquals(questionnaireList.get(1).getQuestion(), "Country of residence888");
        assertNotEquals(questionnaireList.get(2).getQuestion(), "City of residence888");
        assertNotEquals(questionnaireList.get(3).getQuestion(), "Higher education888");
        assertNotEquals(questionnaireList.get(4).getQuestion(), "Your profession888");
    }
}