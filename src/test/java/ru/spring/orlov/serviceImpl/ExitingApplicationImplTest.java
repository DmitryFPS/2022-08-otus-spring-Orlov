package ru.spring.orlov.serviceImpl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.spring.orlov.service.ExitingApplication;

@DisplayName("Class ExitingApplicationImpl")
@ExtendWith(MockitoExtension.class)
class ExitingApplicationImplTest {

    private ExitingApplication exitingApplication;

    @BeforeEach
    void setUp() {
        exitingApplication = new ExitingApplicationImpl();
    }

    @Test
    void exitApp() {

    }
}