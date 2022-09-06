package ru.spring.orlov.service;

import ru.spring.orlov.model.QuestionAndAnswer;

import java.util.List;

public interface QuestionAndAnswerService {

    List<QuestionAndAnswer> findByQuestionAndAnswer();
}