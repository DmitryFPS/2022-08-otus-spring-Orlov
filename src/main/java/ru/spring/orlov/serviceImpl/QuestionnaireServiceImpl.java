package ru.spring.orlov.serviceImpl;

import lombok.RequiredArgsConstructor;
import ru.spring.orlov.dao.QuestionnaireDao;
import ru.spring.orlov.model.Questionnaire;
import ru.spring.orlov.service.QuestionnaireService;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

@RequiredArgsConstructor
public class QuestionnaireServiceImpl implements QuestionnaireService {

    private final QuestionnaireDao questionnaireDao;

    @Override
    public Scanner scanner() {
        return new Scanner(System.in);
    }

    @Override
    public Map<String, String> basicQuestions() {
        Map<String, String> map = new LinkedHashMap<>();
        System.out.println("Your name");
        map.put("Your name", scanner().next());
        System.out.println("Your last name");
        map.put("Your last name", scanner().next());
        return map;
    }

    @Override
    public List<Questionnaire> findByQuestionAndAnswer() {
        return questionnaireDao.findByQuestionAndAnswer();
    }
}