package ru.spring.orlov.serviceImpl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.spring.orlov.service.ApplicationMenuPrintService;
import ru.spring.orlov.service.IOService;
import ru.spring.orlov.service.QuestionnaireService;

@Service
@RequiredArgsConstructor
public class ApplicationMenuPrintServiceImpl implements ApplicationMenuPrintService {

    private final IOService ioService;

    private final QuestionnaireService questionnaireService;

    @Override
    public void showMenuItems() {
        ioService.outputString("Choose one of the following actions...");
        ioService.outputString("1. Test result");
        ioService.outputString("2. Exit");
    }

    @Override
    public void showTest() {
        questionnaireService.getQuestions().forEach(result -> ioService
                .outputString(result.getQuestion() + " : " + result.getAnswerOne() + " and " + result.getAnswerTwo()));
    }
}