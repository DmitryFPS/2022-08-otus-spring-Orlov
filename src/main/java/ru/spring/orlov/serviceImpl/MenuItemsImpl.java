package ru.spring.orlov.serviceImpl;

import org.springframework.stereotype.Service;
import ru.spring.orlov.model.MenuOption;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class MenuItemsImpl {
    public Map<Integer, MenuOption> displayMenuItems() {
        List<MenuOption> optionList = Arrays.asList(
                new MenuOption(1, "Test results"),
                new MenuOption(2, "Exit"));
        return optionList.stream().collect(Collectors.toMap(
                MenuOption::getId,
                Function.identity(),
                (a, b) -> a,
                LinkedHashMap::new
        ));
    }
}