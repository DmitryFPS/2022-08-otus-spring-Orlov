package ru.spring.orlov.serviceImpl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.spring.orlov.model.MenuOption;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

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
    void displayMenuItemsSuccessfulTest() {
        List<MenuOption> optionList = menuItems.displayMenuItems();
        assertEquals(optionList.get(0).getId(), 1);
        assertEquals(optionList.get(0).getDescription(), "Test results");
        assertEquals(optionList.get(1).getId(), 2);
        assertEquals(optionList.get(1).getDescription(), "Exit");
    }

    @Test
    @DisplayName("Test check, list menu option not successful")
    void displayMenuItemsNotSuccessfulTest() {
        List<MenuOption> optionList = menuItems.displayMenuItems();
        assertNotEquals(optionList.get(0).getId(), 888);
        assertNotEquals(optionList.get(0).getDescription(), "Test results888");
        assertNotEquals(optionList.get(1).getId(), 888);
        assertNotEquals(optionList.get(1).getDescription(), "Exit888");
    }
}