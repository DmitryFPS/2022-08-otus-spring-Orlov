package ru.spring.orlov;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.spring.orlov.configuration.AppConfig;
import ru.spring.orlov.view.StartPage;

public class Main {
    public static void main(String[] args) {
        try (AnnotationConfigApplicationContext context =
                     new AnnotationConfigApplicationContext(AppConfig.class)) {
            StartPage startPage =
                    context.getBean("startPage", StartPage.class);
            startPage.basicQuestions();
            startPage.testing();
        }
    }
}