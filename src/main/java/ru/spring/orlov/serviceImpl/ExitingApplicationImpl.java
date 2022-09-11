package ru.spring.orlov.serviceImpl;

import org.springframework.stereotype.Service;
import ru.spring.orlov.service.ExitingApplication;

@Service
public class ExitingApplicationImpl implements ExitingApplication {
    @Override
    public boolean exitApp(String nameAndLastNameStudent) {
        System.out.println("By " + nameAndLastNameStudent);
        return true;
    }
}