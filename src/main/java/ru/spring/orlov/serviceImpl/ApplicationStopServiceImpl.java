package ru.spring.orlov.serviceImpl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.spring.orlov.service.ApplicationStopService;
import ru.spring.orlov.service.IOService;

@Service
@RequiredArgsConstructor
public class ApplicationStopServiceImpl implements ApplicationStopService {

    private final IOService ioService;

    @Override
    public void exitApp() {
        ioService.outputString("By");
    }
}