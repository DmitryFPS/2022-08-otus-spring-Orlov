package ru.spring.orlov.daoSimpl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.spring.orlov.dao.QuestionnaireDao;
import ru.spring.orlov.exception.CSVReaderException;
import ru.spring.orlov.model.Questionnaire;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@DisplayName("Class QuestionAndAnswerDaoSimple")
@ExtendWith(MockitoExtension.class)
class QuestionnaireDaoCSVTest {

    private static final String FIELD_NAME = "resultTestings.csv";

    private QuestionnaireDao questionnaireDao;
    private List<Questionnaire> answerList;

    @BeforeEach
    void setUp() {
        answerList = Arrays.asList(
                new Questionnaire("Do you have any development experience", "yes"),
                new Questionnaire("Are you over 30 years old", "yes"),
                new Questionnaire("Do you have a higher education", "yes"),
                new Questionnaire("Do you live in Russia", "yes"),
                new Questionnaire("Were you born in Russia", "no"));
        questionnaireDao = mock(QuestionnaireDaoCSV.class);
    }

    @Test
    @DisplayName("Test verification, we get the correct fields")
    void testResultsSuccessful() {
        when(questionnaireDao.testResults(FIELD_NAME)).thenReturn(answerList);
        List<Questionnaire> questionnaireList = questionnaireDao.testResults(FIELD_NAME);
        assertNotEquals(questionnaireList.size(), 0);
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
    void testResultsNotSuccessful() {
        when(questionnaireDao.testResults(FIELD_NAME)).thenReturn(answerList);
        List<Questionnaire> questionnaireList = questionnaireDao.testResults(FIELD_NAME);
        assertNotEquals(questionnaireList.size(), 888);
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

    @Test()
    @DisplayName("Test check, we get an exception")
    void testResultsException() {
        when(questionnaireDao.testResults("xxx.csv")).thenThrow(new CSVReaderException("Error reader csv questions and answer"));
        assertThrows(CSVReaderException.class, () -> {
            questionnaireDao.testResults("xxx.csv");
        });
    }
}