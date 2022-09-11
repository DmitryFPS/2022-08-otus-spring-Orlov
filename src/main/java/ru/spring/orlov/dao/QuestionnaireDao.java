package ru.spring.orlov.dao;

import ru.spring.orlov.model.Questionnaire;

import java.util.List;

public interface QuestionnaireDao {
    List<Questionnaire> getByQuestion();

    List<Questionnaire> getByQuestionAndAnswer();
}