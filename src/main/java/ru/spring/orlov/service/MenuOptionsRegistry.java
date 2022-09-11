package ru.spring.orlov.service;

import ru.spring.orlov.model.MenuOption;

import java.util.List;

public interface MenuOptionsRegistry {
    List<MenuOption> getAvailableMenuOptions();
}