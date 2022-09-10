package ru.spring.orlov.serviceImpl;

import lombok.RequiredArgsConstructor;
import ru.spring.orlov.dao.QuestionnaireDao;
import ru.spring.orlov.model.Questionnaire;
import ru.spring.orlov.service.QuestionnaireService;

import java.util.List;

@RequiredArgsConstructor
public class QuestionnaireServiceImpl implements QuestionnaireService {
    private final QuestionnaireDao questionnaireDao;

    @Override
    public List<Questionnaire> findByQuestionAndAnswer() {
        return questionnaireDao.findByQuestionAndAnswer();
    }
}