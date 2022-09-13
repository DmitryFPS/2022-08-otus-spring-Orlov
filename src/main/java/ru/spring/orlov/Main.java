package ru.spring.orlov;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.spring.orlov.configuration.AppConfig;
import ru.spring.orlov.service.ApplicationRunner;

public class Main {
    public static void main(String[] args) {
        try (AnnotationConfigApplicationContext context =
                     new AnnotationConfigApplicationContext(AppConfig.class)) {
            ApplicationRunner applicationRunner = context.getBean(ApplicationRunner.class);
            applicationRunner.run();
        }
    }
}