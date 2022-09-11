package ru.spring.orlov;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.spring.orlov.configuration.AppConfig;
import ru.spring.orlov.serviceImpl.ApplicationRunnerImpl;

public class Main {
    public static void main(String[] args) {
        try (AnnotationConfigApplicationContext context =
                     new AnnotationConfigApplicationContext(AppConfig.class)) {
            ApplicationRunnerImpl applicationRunner = context.getBean("applicationRunnerImpl", ApplicationRunnerImpl.class);
            applicationRunner.run();
        }
    }
}