package ru.spring.orlov;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.spring.orlov.configuration.AppConfig;
import ru.spring.orlov.service.ApplicationMenuService;
import ru.spring.orlov.service.BasicQuestionStudentService;

public class Main {
    public static void main(String[] args) {
        try (AnnotationConfigApplicationContext context =
                     new AnnotationConfigApplicationContext(AppConfig.class)) {

            BasicQuestionStudentService basicQuestionStudentService = context.getBean(BasicQuestionStudentService.class);
            ApplicationMenuService applicationMenuService = context.getBean(ApplicationMenuService.class);

            basicQuestionStudentService.askStudentBasicQuestion();
            applicationMenuService.outputMenu();
            applicationMenuService.selectMenuItem();
        }
    }
}