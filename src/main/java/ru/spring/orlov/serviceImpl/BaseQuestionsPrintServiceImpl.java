package ru.spring.orlov.serviceImpl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.spring.orlov.service.BaseQuestionsPrintService;
import ru.spring.orlov.service.IOService;

@Service
@RequiredArgsConstructor
public class BaseQuestionsPrintServiceImpl implements BaseQuestionsPrintService {

    private final IOService ioService;

    @Override
    public void askForName() {
        ioService.outputString("Your name");
    }

    @Override
    public void askForLastName() {
        ioService.outputString("Your last name");
    }

    @Override
    public void getBasicQuestion(String basicQuestion) {
        ioService.outputString(String.join(" ", basicQuestion.split(",")));
    }
}