package ru.spring.orlov.serviceImpl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.spring.orlov.exception.NoSuchMenuItem;
import ru.spring.orlov.service.ExitingApplication;
import ru.spring.orlov.service.IOService;
import ru.spring.orlov.service.MenuOptionsRegistry;
import ru.spring.orlov.service.QuestionnaireService;

@Service
@RequiredArgsConstructor
public class ApplicationRunner {
    private static final int TEST_RESULT = 1;
    private static final int EXIT = 2;

    private static final String FIELD_NAME = "resultTestings.csv";

    private final IOService ioService;
    private final QuestionnaireService questionnaireService;
    private final MenuOptionsRegistry menuOptionsRegistry;
    private final ExitingApplication exitingApplication;

    public void run() {
        outputMenu();
    }

    private void outputMenu() {
        StringBuilder resultTest = new StringBuilder();
        ioService.outputString("Your name");
        resultTest.append(ioService.reader().next()).append(",");
        ioService.outputString("Your last name");
        resultTest.append(ioService.reader().next());
        System.out.println();
        ioService.outputString("Choose one of the following actions...");
        String nameAndLastNameStudent = String.join(" ", resultTest.toString().split(","));
        System.out.println("Hello " + nameAndLastNameStudent);
        menuOptionsRegistry.getAvailableMenuOptions().forEach(System.out::println);
        menuItems(nameAndLastNameStudent);
    }

    private void menuItems(String nameAndLastNameStudent) {
        int menuItem = ioService.reader().nextInt();
        if (menuItem == TEST_RESULT) {
            System.out.println();
            questionnaireService.testing(FIELD_NAME).forEach(result -> System.out.println(result.getQuestion() + " : " + result.getAnswer()));
        } else if (menuItem == EXIT) {
            System.out.println();
            exitingApplication.exitApp(nameAndLastNameStudent);
        } else {
            throw new NoSuchMenuItem("There is no such menu item");
        }
    }
}