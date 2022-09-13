package ru.spring.orlov.serviceImpl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.spring.orlov.service.BaseQuestionsPrintService;
import ru.spring.orlov.service.BasicQuestionStudentService;
import ru.spring.orlov.service.IOService;

@Service
@RequiredArgsConstructor
public class BasicQuestionStudentServiceImpl implements BasicQuestionStudentService {

    private final IOService ioService;
    private final BaseQuestionsPrintService baseQuestionsPrintService;

    @Override
    public void askStudentBasicQuestion() {
        StringBuilder basicQuestion = new StringBuilder("Hello ");
        baseQuestionsPrintService.askForName();
        basicQuestion.append(readSelectedOption()).append(",");
        baseQuestionsPrintService.askForLastName();
        basicQuestion.append(readSelectedOption());
        baseQuestionsPrintService.getBasicQuestion(basicQuestion.toString());
    }

    public String readSelectedOption() {
        return ioService.readStringNext();
    }
}