package ru.spring.orlov.service;

import ru.spring.orlov.model.Questionnaire;

import java.util.List;

public interface QuestionnaireService {
    List<Questionnaire> findByQuestionAndAnswer();
}