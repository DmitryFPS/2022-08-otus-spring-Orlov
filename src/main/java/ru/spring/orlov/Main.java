package ru.spring.orlov;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.spring.orlov.view.StartPage;

public class Main {
    public static void main(String[] args) {
        try (ClassPathXmlApplicationContext context =
                     new ClassPathXmlApplicationContext("spring-context.xml")) {
            StartPage startPage =
                    context.getBean("startPage", StartPage.class);
            startPage.basicQuestions();
            startPage.testing();
        }
    }
}