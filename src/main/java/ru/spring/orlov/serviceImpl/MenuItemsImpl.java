package ru.spring.orlov.serviceImpl;

import org.springframework.stereotype.Service;
import ru.spring.orlov.model.MenuOption;
import ru.spring.orlov.service.MenuItems;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class MenuItemsImpl implements MenuItems {
    @Override
    public List<MenuOption> displayMenuItems() {
        List<MenuOption> optionList = Arrays.asList(
                new MenuOption(1, "Test results"),
                new MenuOption(2, "Exit"));

        return optionList.stream().collect(Collectors.toMap(
                MenuOption::getId,
                Function.identity(),
                (a, b) -> a,
                LinkedHashMap::new
        )).values().stream().map(menuOption -> new MenuOption(menuOption.getId(), menuOption.getDescription())).collect(Collectors.toList());
    }
}