package ru.spring.orlov.serviceImpl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.spring.orlov.exception.NoSuchMenuItem;
import ru.spring.orlov.service.ApplicationRunner;
import ru.spring.orlov.service.ExitingApplication;
import ru.spring.orlov.service.IOService;
import ru.spring.orlov.service.QuestionnaireService;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@DisplayName("Class ApplicationRunnerImpl")
@ExtendWith(MockitoExtension.class)
class ApplicationRunnerImplTest {

    private static final int TEST_RESULT = 1;
    private static final int EXIT = 2;

    private static final int INVALID_MENU_ITEM = 888;

    private ApplicationRunner applicationRunner;
    private IOService ioService;
    private QuestionnaireService questionnaireService;
    private MenuItemsImpl menuItems;
    private ExitingApplication exitingApplication;

    @BeforeEach
    void setUp() {
        ioService = mock(IOServiceStreams.class);
        questionnaireService = mock(QuestionnaireService.class);
        menuItems = mock(MenuItemsImpl.class);
        exitingApplication = mock(ExitingApplication.class);
        applicationRunner = new ApplicationRunnerImpl(ioService, questionnaireService, menuItems, exitingApplication);
    }

    @Test
    @DisplayName("Test check, method run, result test")
    void runResultTest() {
        when(ioService.readStringNext()).thenReturn("Dima");
        when(ioService.readIntNext()).thenReturn(TEST_RESULT);
        applicationRunner.run();
    }

    @Test
    @DisplayName("Test check, method output menu, result test")
    void outputMenuResultTest() {
        when(ioService.readStringNext()).thenReturn("Dima");
        when(ioService.readIntNext()).thenReturn(TEST_RESULT);
        applicationRunner.outputMenu();
    }

    @Test
    @DisplayName("Test check, method items menu, result test")
    void menuItemsResultTest() {
        when(ioService.readIntNext()).thenReturn(TEST_RESULT);
        applicationRunner.menuItems("Dima Dima");
    }

    @Test
    @DisplayName("Test check, method run, exit")
    void runExitTest() {
        when(ioService.readStringNext()).thenReturn("Dima");
        when(ioService.readIntNext()).thenReturn(EXIT);
        applicationRunner.run();
    }

    @Test
    @DisplayName("Test check, method output menu, exit")
    void outputMenuExitTest() {
        when(ioService.readStringNext()).thenReturn("Dima");
        when(ioService.readIntNext()).thenReturn(EXIT);
        applicationRunner.outputMenu();
    }

    @Test
    @DisplayName("Test check, method items menu, exit")
    void menuItemsExitTest() {
        when(ioService.readIntNext()).thenReturn(EXIT);
        applicationRunner.menuItems("Dima Dima");
    }

    @Test
    @DisplayName("Test check, method run, invalid menu item")
    void runInvalidMenuItemTest() {
        when(ioService.readStringNext()).thenReturn("Dima");
        when(ioService.readIntNext()).thenReturn(INVALID_MENU_ITEM);
        assertThrows(NoSuchMenuItem.class, () -> {
            applicationRunner.run();
        });
    }

    @Test
    @DisplayName("Test check, method output menu, invalid menu item")
    void outputMenuInvalidMenuItemTest() {
        when(ioService.readStringNext()).thenReturn("Dima");
        when(ioService.readIntNext()).thenReturn(INVALID_MENU_ITEM);
        assertThrows(NoSuchMenuItem.class, () -> {
            applicationRunner.outputMenu();
        });
    }

    @Test
    @DisplayName("Test check, method items menu, invalid menu item")
    void menuItemsInvalidMenuItemTest() {
        when(ioService.readIntNext()).thenReturn(INVALID_MENU_ITEM);
        assertThrows(NoSuchMenuItem.class, () -> {
            applicationRunner.menuItems("Dima Dima");
        });
    }
}