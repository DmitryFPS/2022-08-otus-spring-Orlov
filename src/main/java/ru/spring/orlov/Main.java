package ru.spring.orlov;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.spring.orlov.model.Questionnaire;
import ru.spring.orlov.service.QuestionnaireService;

import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        try (ClassPathXmlApplicationContext context =
                     new ClassPathXmlApplicationContext("spring-context.xml")) {

            QuestionnaireService questionnaire =
                    context.getBean("questionAndAnswerServiceImpl", QuestionnaireService.class);

            Map<String, String> basicQuestions = questionnaire.basicQuestions();
            for (Map.Entry<String, String> map : basicQuestions.entrySet()) {
                System.out.println(map.getKey() + " " + map.getValue());
            }

            List<Questionnaire> result = questionnaire.findByQuestionAndAnswer();
            for (Questionnaire q : result) {
                System.out.println(q.getQuestion());
            }
        }

    }
}