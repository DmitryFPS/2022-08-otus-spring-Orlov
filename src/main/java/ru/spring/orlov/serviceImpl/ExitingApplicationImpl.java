package ru.spring.orlov.serviceImpl;

import org.springframework.stereotype.Service;
import ru.spring.orlov.service.ExitingApplication;

@Service
public class ExitingApplicationImpl implements ExitingApplication {
    @Override
    public void exitApp(String nameAndLastNameStudent) {
        System.out.println("By " + nameAndLastNameStudent);
    }
}