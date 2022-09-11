package ru.spring.orlov.serviceImpl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.spring.orlov.dao.QuestionnaireDao;
import ru.spring.orlov.model.Questionnaire;
import ru.spring.orlov.service.QuestionnaireService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class QuestionnaireServiceImpl implements QuestionnaireService {
    private final QuestionnaireDao questionnaireDao;

    @Override
    public List<Questionnaire> testing(String fileName) {
        return questionnaireDao.testResults(fileName);
    }
}