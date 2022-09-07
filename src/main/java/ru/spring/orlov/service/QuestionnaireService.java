package ru.spring.orlov.service;

import ru.spring.orlov.model.Questionnaire;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public interface QuestionnaireService {
    Scanner scanner();

    Map<String, String> basicQuestions();

    List<Questionnaire> findByQuestionAndAnswer();
}