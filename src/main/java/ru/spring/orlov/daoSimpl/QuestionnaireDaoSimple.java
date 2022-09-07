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
public class QuestionnaireDaoSimple implements QuestionnaireDao {

    private String nameFile;

    @Override
    @SuppressWarnings({"rawtypes", "unchecked"})
    public List<Questionnaire> findByQuestionAndAnswer() {
        List<Questionnaire> answerList = new ArrayList<>();

        try (InputStream resource = new ClassPathResource(nameFile).getInputStream();
             InputStreamReader inputStreamReader = new InputStreamReader(resource);
             CSVReader reader = new CSVReader(inputStreamReader, ',', '"', 0)) {

            CsvToBean csv = new CsvToBean();
            List list = csv.parse(setColumMapping(), reader);
            for (Object object : list) {
                answerList.add((Questionnaire) object);
            }

        } catch (IOException e) {
            System.out.println("Error I/O " + e);
        }

        return answerList;
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    private static ColumnPositionMappingStrategy setColumMapping() {
        ColumnPositionMappingStrategy strategy = new ColumnPositionMappingStrategy();
        strategy.setType(Questionnaire.class);
        String[] columns = new String[]{"question"};
        strategy.setColumnMapping(columns);
        return strategy;
    }
}