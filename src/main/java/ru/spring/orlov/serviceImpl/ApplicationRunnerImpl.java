package ru.spring.orlov.serviceImpl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.spring.orlov.exception.NoSuchMenuItem;
import ru.spring.orlov.service.ApplicationRunner;
import ru.spring.orlov.service.ApplicationStopService;
import ru.spring.orlov.service.IOService;
import ru.spring.orlov.service.QuestionnaireService;

@Service
@RequiredArgsConstructor
public class ApplicationRunnerImpl implements ApplicationRunner {
    private static final int TEST_RESULT = 1;
    private static final int EXIT = 2;
    private final IOService ioService;
    private final QuestionnaireService questionnaireService;
    private final ApplicationStopService applicationStopService;

    @Override
    public void run() {
        basicQuestionAndStudentTesting();
        outputMenu();
    }

    @Override
    public void basicQuestionAndStudentTesting() {
        StringBuilder basicQuestion = new StringBuilder();
        ioService.outputString("Your name");
        basicQuestion.append(readSelectedOption()).append(",");
        ioService.outputString("Your last name");
        basicQuestion.append(readSelectedOption());
        String nameAndLastNameStudent = String.join(" ", basicQuestion.toString().split(","));
        ioService.outputString("Hello " + nameAndLastNameStudent);
    }

    private void outputMenu() {
        ioService.outputString("Choose one of the following actions...");
        ioService.outputString("1. Test");
        ioService.outputString("2. Exit");
        selectMenuItem();
    }

    @Override
    public void selectMenuItem() {
        int menuItem = ioService.readIntNext();
        if (menuItem == TEST_RESULT) {
            questionnaireService.getQuestions().forEach(result -> ioService.outputString(result.getQuestion() + " : " + result.getAnswerOne() + " and " + result.getAnswerTwo()));
        } else if (menuItem == EXIT) {
            applicationStopService.exitApp();
        } else {
            throw new NoSuchMenuItem("There is no such menu item");
        }
    }

    public String readSelectedOption() {
        return ioService.readStringNext();
    }
}