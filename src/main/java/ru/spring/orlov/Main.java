package ru.spring.orlov;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.spring.orlov.model.QuestionAndAnswer;
import ru.spring.orlov.service.QuestionAndAnswerService;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        try (ClassPathXmlApplicationContext context =
                     new ClassPathXmlApplicationContext("spring-context.xml")) {
            QuestionAndAnswerService questionAndAnswerService =
                    context.getBean("questionAndAnswerServiceImpl", QuestionAndAnswerService.class);
            List<QuestionAndAnswer> result = questionAndAnswerService.findByQuestionAndAnswer();

            for (QuestionAndAnswer q : result) {
                System.out.println("Вопрос " + q.getQuestion());
                System.out.println("Ответ " + q.getAnswer());
                System.out.println();
            }
        }
    }
}