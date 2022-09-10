package ru.spring.orlov.daoSimpl;

import au.com.bytecode.opencsv.CSVReader;
import au.com.bytecode.opencsv.bean.ColumnPositionMappingStrategy;
import au.com.bytecode.opencsv.bean.CsvToBean;
import lombok.AllArgsConstructor;
import org.springframework.core.io.ClassPathResource;
import ru.spring.orlov.dao.QuestionnaireDao;
import ru.spring.orlov.model.Questionnaire;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
public class QuestionnaireDaoCSV implements QuestionnaireDao {

    private String nameFile;

    @Override
    public List<Questionnaire> findByQuestionAndAnswer() {
        List<Questionnaire> answerList = new ArrayList<>();

        try (InputStream resource = new ClassPathResource(nameFile).getInputStream();
             InputStreamReader inputStreamReader = new InputStreamReader(resource);
             CSVReader reader = new CSVReader(inputStreamReader, ',', '"', 0)) {

            CsvToBean<Questionnaire> csv = new CsvToBean<>();
            List<Questionnaire> list = csv.parse(setColumMapping(), reader);
            answerList.addAll(list);

        } catch (IOException e) {
            System.out.println("Error I/O " + e);
        }
        return answerList;
    }

    private static ColumnPositionMappingStrategy<Questionnaire> setColumMapping() {
        ColumnPositionMappingStrategy<Questionnaire> strategy = new ColumnPositionMappingStrategy<>();
        strategy.setType(Questionnaire.class);
        String[] columns = new String[]{"question", "answer"};
        strategy.setColumnMapping(columns);
        return strategy;
    }
}