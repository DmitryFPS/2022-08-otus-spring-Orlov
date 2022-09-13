package ru.spring.orlov.serviceImpl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.spring.orlov.service.ApplicationStopService;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("Class ExitingApplicationImpl")
@ExtendWith(MockitoExtension.class)
class ApplicationStopServiceImplTest {

    private ApplicationStopService applicationStopService;

    @BeforeEach
    void setUp() {
        applicationStopService = new ApplicationStopServiceImpl();
    }

    @Test
    @DisplayName("Test check, exit app FIELD NAME Successful")
    void exitAppSuccessfulTest() {
        assertTrue(applicationStopService.exitApp());
    }

    @Test
    @DisplayName("Test check, exit app FIELD NAME not Successful")
    void exitAppNotSuccessfulTest() {
        assertNotEquals(applicationStopService.exitApp(), false);
    }
}