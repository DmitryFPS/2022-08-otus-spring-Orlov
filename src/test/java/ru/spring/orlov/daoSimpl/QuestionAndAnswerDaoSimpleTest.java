package ru.spring.orlov.daoSimpl;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.spring.orlov.dao.QuestionAndAnswerDao;
import ru.spring.orlov.model.QuestionAndAnswer;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@DisplayName("Class QuestionAndAnswerDaoSimple")
class QuestionAndAnswerDaoSimpleTest {

    private QuestionAndAnswerDao subj;
    private ClassPathXmlApplicationContext context;

    @BeforeEach
    void setUp() {
        context = new ClassPathXmlApplicationContext("spring-context.xml");
        subj = context.getBean("questionAndAnswerDaoSimple", QuestionAndAnswerDaoSimple.class);
    }

    @AfterEach
    void tearDown() {
        context.close();
    }

    @Test
    @DisplayName("Test verification, we get the correct fields")
    void findByQuestionAndAnswerSuccessful() {
        List<QuestionAndAnswer> answerList = subj.findByQuestionAndAnswer();
        assertNotEquals(answerList.size(), 0);
        assertEquals(answerList.get(0).getQuestion(), "Your name");
        assertEquals(answerList.get(1).getQuestion(), "Your last name");
        assertEquals(answerList.get(2).getQuestion(), "Your age");
        assertEquals(answerList.get(3).getQuestion(), "Country of residence");
        assertEquals(answerList.get(4).getQuestion(), "City of residence");
    }

    @Test
    @DisplayName("Test check, we get incorrect fields")
    void findByQuestionAndAnswerNotSuccessful() {
        List<QuestionAndAnswer> answerList = subj.findByQuestionAndAnswer();
        assertNotEquals(answerList.size(), 888);
        assertNotEquals(answerList.get(0).getQuestion(), "Your name888");
        assertNotEquals(answerList.get(1).getQuestion(), "Your last name888");
        assertNotEquals(answerList.get(2).getQuestion(), "Your age888");
        assertNotEquals(answerList.get(3).getQuestion(), "Country of residence888");
        assertNotEquals(answerList.get(4).getQuestion(), "City of residence888");
    }
}