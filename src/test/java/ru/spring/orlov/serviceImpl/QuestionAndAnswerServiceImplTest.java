package ru.spring.orlov.serviceImpl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import ru.spring.orlov.dao.QuestionAndAnswerDao;
import ru.spring.orlov.daoSimpl.QuestionAndAnswerDaoSimple;
import ru.spring.orlov.model.QuestionAndAnswer;
import ru.spring.orlov.service.QuestionAndAnswerService;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@DisplayName("Class QuestionAndAnswerServiceImpl")
@RunWith(MockitoJUnitRunner.class)
class QuestionAndAnswerServiceImplTest {

    private QuestionAndAnswerService subj;

    private QuestionAndAnswerDao questionAndAnswerDao;

    @BeforeEach
    void setUp() {
        questionAndAnswerDao = mock(QuestionAndAnswerDaoSimple.class);
        subj = new QuestionAndAnswerServiceImpl(questionAndAnswerDao);
    }

    @Test
    @DisplayName("Test verification, we get the correct fields")
    void findByQuestionAndAnswerSuccessful() {
        List<QuestionAndAnswer> answerList = Arrays.asList(
                new QuestionAndAnswer("Your name", "Dmitry"),
                new QuestionAndAnswer("Your last name", "Orlov"),
                new QuestionAndAnswer("Your age", "36"),
                new QuestionAndAnswer("Country of residence", "Russia"),
                new QuestionAndAnswer("City of residence", "Samara"));
        when(questionAndAnswerDao.findByQuestionAndAnswer()).thenReturn(answerList);

        List<QuestionAndAnswer> questionAndAnswerList = subj.findByQuestionAndAnswer();
        assertEquals(answerList, questionAndAnswerList);
        assertEquals(answerList.size(), questionAndAnswerList.size());

        assertEquals(questionAndAnswerList.get(0).getQuestion(), "Your name");
        assertEquals(questionAndAnswerList.get(1).getQuestion(), "Your last name");
        assertEquals(questionAndAnswerList.get(2).getQuestion(), "Your age");
        assertEquals(questionAndAnswerList.get(3).getQuestion(), "Country of residence");
        assertEquals(questionAndAnswerList.get(4).getQuestion(), "City of residence");
    }

    @Test
    @DisplayName("Test check, we get incorrect fields")
    void findByQuestionAndAnswerNotSuccessful() {
        List<QuestionAndAnswer> answerList = Arrays.asList(
                new QuestionAndAnswer("Your name", "Dmitry"),
                new QuestionAndAnswer("Your last name", "Orlov"),
                new QuestionAndAnswer("Your age", "36"),
                new QuestionAndAnswer("Country of residence", "Russia"),
                new QuestionAndAnswer("City of residence", "Samara"));
        when(questionAndAnswerDao.findByQuestionAndAnswer()).thenReturn(answerList);

        List<QuestionAndAnswer> questionAndAnswerList = subj.findByQuestionAndAnswer();

        assertNotEquals(questionAndAnswerList.get(0).getQuestion(), "Your name888");
        assertNotEquals(questionAndAnswerList.get(1).getQuestion(), "Your last name888");
        assertNotEquals(questionAndAnswerList.get(2).getQuestion(), "Your age888");
        assertNotEquals(questionAndAnswerList.get(3).getQuestion(), "Country of residence888");
        assertNotEquals(questionAndAnswerList.get(4).getQuestion(), "City of residence888");
    }
}