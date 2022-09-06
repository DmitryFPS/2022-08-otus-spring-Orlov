package ru.spring.orlov.serviceImpl;

import lombok.RequiredArgsConstructor;
import ru.spring.orlov.dao.QuestionAndAnswerDao;
import ru.spring.orlov.model.QuestionAndAnswer;
import ru.spring.orlov.service.QuestionAndAnswerService;

import java.util.List;

@RequiredArgsConstructor
public class QuestionAndAnswerServiceImpl implements QuestionAndAnswerService {

    private final QuestionAndAnswerDao questionAndAnswerDao;

    @Override
    public List<QuestionAndAnswer> findByQuestionAndAnswer() {
        return questionAndAnswerDao.findByQuestionAndAnswer();
    }
}