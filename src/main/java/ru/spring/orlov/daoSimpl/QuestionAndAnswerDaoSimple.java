package ru.spring.orlov.daoSimpl;

import au.com.bytecode.opencsv.CSVReader;
import lombok.AllArgsConstructor;
import ru.spring.orlov.dao.QuestionAndAnswerDao;
import ru.spring.orlov.exception.CustomException;
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
            String[] nextLine;
            while ((nextLine = reader.readNext()) != null) {
                if (nextLine.length == 2) {
                    answerList.add(new QuestionAndAnswer(nextLine[0], nextLine[1]));
                } else {
                    throw new CustomException("Invalid set of rows or columns in the csv file " + nameFile);
                }
            }
        } catch (IOException e) {
            System.out.println("Error CSVReader" + e);
        }
        return answerList;
    }
}