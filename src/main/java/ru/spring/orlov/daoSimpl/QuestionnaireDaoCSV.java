package ru.spring.orlov.daoSimpl;

import au.com.bytecode.opencsv.CSVReader;
import au.com.bytecode.opencsv.bean.CsvToBean;
import lombok.AllArgsConstructor;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Repository;
import ru.spring.orlov.dao.QuestionnaireDao;
import ru.spring.orlov.exception.CSVReaderException;
import ru.spring.orlov.model.Questionnaire;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import static ru.spring.orlov.configuration.AppConfig.setColumnMappingByQuestions;

@Repository
@AllArgsConstructor
public class QuestionnaireDaoCSV implements QuestionnaireDao {

    @Override
    public List<Questionnaire> getByQuestion() {
        List<Questionnaire> answerList = new ArrayList<>();

        try (InputStream resource = new ClassPathResource("questions.csv").getInputStream();
             InputStreamReader inputStreamReader = new InputStreamReader(resource);
             CSVReader reader = new CSVReader(inputStreamReader)) {

            CsvToBean<Questionnaire> csv = new CsvToBean<>();
            List<Questionnaire> list = csv.parse(setColumnMappingByQuestions(), reader);
            answerList.addAll(list);

        } catch (IOException e) {
            throw new CSVReaderException("Error I/O " + e);
        }
        return answerList;
    }

    @Override
    public List<Questionnaire> getByQuestionAndAnswer() {
        return null;
    }
}