package ru.spring.orlov.view;

import lombok.RequiredArgsConstructor;
import ru.spring.orlov.model.Questionnaire;
import ru.spring.orlov.service.QuestionnaireService;

import java.util.List;
import java.util.Scanner;

@RequiredArgsConstructor
public class StartPage {

    private final QuestionnaireService questionnaireService;

    public void basicQuestions() {
        Scanner scanner = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        System.out.println("Your name");
        sb.append(scanner.next()).append(" ");
        System.out.println("Your last name");
        sb.append(scanner.next());
        System.out.println("Hello " + sb);
        System.out.println("--- Take the test ---");
    }

    public void testing() {
        List<Questionnaire> result = questionnaireService.findByQuestionAndAnswer();
        for (Questionnaire q : result) {
            System.out.println("Question: " + q.getQuestion() + " : " + "Answer: " + q.getAnswer());
        }
    }
}