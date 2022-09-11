package ru.spring.orlov;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.spring.orlov.configuration.AppConfig;
import ru.spring.orlov.service.MenuOptionsRegistry;
import ru.spring.orlov.serviceImpl.ApplicationRunner;
import ru.spring.orlov.serviceImpl.MenuOptionsRegistryImpl;

public class Main {
    public static void main(String[] args) {
        try (AnnotationConfigApplicationContext context =
                     new AnnotationConfigApplicationContext(AppConfig.class)) {
            ApplicationRunner applicationRunner = context.getBean("applicationRunner", ApplicationRunner.class);
            applicationRunner.run();
        }
    }
}