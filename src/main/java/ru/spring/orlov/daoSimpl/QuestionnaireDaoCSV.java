package ru.spring.orlov.daoSimpl;

import au.com.bytecode.opencsv.CSVReader;
import au.com.bytecode.opencsv.bean.ColumnPositionMappingStrategy;
import au.com.bytecode.opencsv.bean.CsvToBean;
import lombok.RequiredArgsConstructor;
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

@Repository
@RequiredArgsConstructor
public class QuestionnaireDaoCSV implements QuestionnaireDao {

    private static final String FILE_NAME = "resultTestings.csv";

    public List<Questionnaire> getQuestions() {
        List<Questionnaire> answerList = new ArrayList<>();

        try (InputStream resource = new ClassPathResource(FILE_NAME).getInputStream();
             InputStreamReader inputStreamReader = new InputStreamReader(resource);
             CSVReader reader = new CSVReader(inputStreamReader, ',', '"', 0)) {

            CsvToBean<Questionnaire> csv = new CsvToBean<>();
            List<Questionnaire> list = csv.parse(setColumnMapping(new String[]{"question", "answerOne", "answerTwo"}), reader);
            answerList.addAll(list);

        } catch (IOException e) {
            throw new CSVReaderException("Error reader csv questions and answer " + e);
        }
        return answerList;
    }

    public static ColumnPositionMappingStrategy<Questionnaire> setColumnMapping(String[] strings) {
        ColumnPositionMappingStrategy<Questionnaire> strategy = new ColumnPositionMappingStrategy<>();
        strategy.setType(Questionnaire.class);
        strategy.setColumnMapping(strings);
        return strategy;
    }
}