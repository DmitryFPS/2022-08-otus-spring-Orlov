package ru.spring.orlov.daoSimpl;

import au.com.bytecode.opencsv.CSVReader;
import au.com.bytecode.opencsv.bean.ColumnPositionMappingStrategy;
import au.com.bytecode.opencsv.bean.CsvToBean;
import lombok.AllArgsConstructor;
import ru.spring.orlov.dao.QuestionAndAnswerDao;
import ru.spring.orlov.model.QuestionAndAnswer;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
public class QuestionAndAnswerDaoSimple implements QuestionAndAnswerDao {

    private String nameFile;

    @Override
    @SuppressWarnings({"rawtypes", "unchecked"})
    public List<QuestionAndAnswer> findByQuestionAndAnswer() {
        List<QuestionAndAnswer> answerList = new ArrayList<>();
        ClassLoader classLoader = getClass().getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream(nameFile);
        InputStreamReader inputStreamReader;
        if (inputStream != null) {
            inputStreamReader = new InputStreamReader(inputStream);
        } else {
            throw new IllegalArgumentException("file not found " + nameFile);
        }
        try (CSVReader reader = new CSVReader(inputStreamReader, ',', '"', 0)) {
            CsvToBean csv = new CsvToBean();
            List list = csv.parse(setColumMapping(), reader);
            for (Object object : list) {
                QuestionAndAnswer questionAndAnswer = (QuestionAndAnswer) object;
                answerList.add(questionAndAnswer);
            }
        } catch (IOException e) {
            System.out.println("Error CSVReader" + e);
        }
        return answerList;
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    private static ColumnPositionMappingStrategy setColumMapping() {
        ColumnPositionMappingStrategy strategy = new ColumnPositionMappingStrategy();
        strategy.setType(QuestionAndAnswer.class);
        String[] columns = new String[]{"question", "answer"};
        strategy.setColumnMapping(columns);
        return strategy;
    }
}