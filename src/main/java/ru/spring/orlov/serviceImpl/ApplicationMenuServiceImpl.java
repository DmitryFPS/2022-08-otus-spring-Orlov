package ru.spring.orlov.serviceImpl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.spring.orlov.exception.NoSuchMenuItem;
import ru.spring.orlov.service.ApplicationMenuPrintService;
import ru.spring.orlov.service.ApplicationMenuService;
import ru.spring.orlov.service.ApplicationStopService;
import ru.spring.orlov.service.IOService;

@Service
@RequiredArgsConstructor
public class ApplicationMenuServiceImpl implements ApplicationMenuService {

    private final IOService ioService;
    private static final int TEST_RESULT = 1;
    private static final int EXIT = 2;
    private final ApplicationStopService applicationStopService;
    private final ApplicationMenuPrintService applicationMenuPrintService;

    @Override
    public void outputMenu() {
        applicationMenuPrintService.showMenuItems();
    }

    @Override
    public void selectMenuItem() {
        int menuItem = ioService.readIntNext();
        if (menuItem == TEST_RESULT) {
            applicationMenuPrintService.showTestResults();
        } else if (menuItem == EXIT) {
            applicationStopService.exitApp();
        } else {
            throw new NoSuchMenuItem("There is no such menu item");
        }
    }
}