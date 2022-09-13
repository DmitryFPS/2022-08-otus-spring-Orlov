package ru.spring.orlov.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Questionnaire {
    private String question;
    private String answerOne;
    private String answerTwo;
}