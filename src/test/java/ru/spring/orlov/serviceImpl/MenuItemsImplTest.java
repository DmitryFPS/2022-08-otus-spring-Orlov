package ru.spring.orlov.serviceImpl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.spring.orlov.model.MenuOption;
import ru.spring.orlov.service.MenuItems;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Class MenuItemsImpl")
@ExtendWith(MockitoExtension.class)
class MenuItemsImplTest {

    private MenuItems menuItems;

    @BeforeEach
    void setUp() {
        menuItems = new MenuItemsImpl();
    }

    @Test
    @DisplayName("Test check, list menu option")
    void displayMenuItemsSuccessful() {
        List<MenuOption> optionList = menuItems.displayMenuItems();
        assertEquals(optionList.get(0).getId(), 1);
        assertEquals(optionList.get(0).getDescription(), "Test results");
        assertEquals(optionList.get(1).getId(), 2);
        assertEquals(optionList.get(1).getDescription(), "Exit");
    }
}