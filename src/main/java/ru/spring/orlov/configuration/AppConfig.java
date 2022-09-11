package ru.spring.orlov.configuration;

import au.com.bytecode.opencsv.bean.ColumnPositionMappingStrategy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import ru.spring.orlov.model.Questionnaire;

@Configuration
@ComponentScan(basePackages = "ru.spring.orlov")
public class AppConfig {

    @Bean
    public static ColumnPositionMappingStrategy<Questionnaire> setColumnMappingByQuestions() {
        ColumnPositionMappingStrategy<Questionnaire> strategy = new ColumnPositionMappingStrategy<>();
        strategy.setType(Questionnaire.class);
        String[] columns = new String[]{"question"};
        strategy.setColumnMapping(columns);
        return strategy;
    }

    @Bean
    public static ColumnPositionMappingStrategy<Questionnaire> setColumnMappingByQuestionsAndAnswer() {
        ColumnPositionMappingStrategy<Questionnaire> strategy = new ColumnPositionMappingStrategy<>();
        strategy.setType(Questionnaire.class);
        String[] columns = new String[]{"question", "answer"};
        strategy.setColumnMapping(columns);
        return strategy;
    }
}