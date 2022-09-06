package ru.spring.orlov.dao;

import ru.spring.orlov.model.QuestionAndAnswer;

import java.util.List;

public interface QuestionAndAnswerDao {
    List<QuestionAndAnswer> findByQuestionAndAnswer();
}