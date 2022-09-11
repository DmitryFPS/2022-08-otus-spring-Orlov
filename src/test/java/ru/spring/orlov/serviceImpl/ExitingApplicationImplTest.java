package ru.spring.orlov.serviceImpl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.spring.orlov.service.ExitingApplication;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("Class ExitingApplicationImpl")
@ExtendWith(MockitoExtension.class)
class ExitingApplicationImplTest {

    private static final String FIELD_NAME = "resultTestings.csv";

    private ExitingApplication exitingApplication;

    @BeforeEach
    void setUp() {
        exitingApplication = new ExitingApplicationImpl();
    }

    @Test
    @DisplayName("Test check, exit app FIELD NAME Successful")
    void exitAppSuccessfulTest() {
        assertTrue(exitingApplication.exitApp(FIELD_NAME));
    }

    @Test
    @DisplayName("Test check, exit app FIELD NAME not Successful")
    void exitAppNotSuccessfulTest() {
        assertNotEquals(exitingApplication.exitApp(FIELD_NAME), false);
    }
}