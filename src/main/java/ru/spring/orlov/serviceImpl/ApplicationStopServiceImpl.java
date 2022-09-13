package ru.spring.orlov.serviceImpl;

import org.springframework.stereotype.Service;
import ru.spring.orlov.service.ApplicationStopService;

@Service
public class ApplicationStopServiceImpl implements ApplicationStopService {
    @Override
    public boolean exitApp() {
        System.out.println("By");
        return true;
    }
}