package ru.spring.orlov.serviceImpl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.spring.orlov.model.MenuOption;
import ru.spring.orlov.service.MenuOptionsRegistry;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MenuOptionsRegistryImpl implements MenuOptionsRegistry {
    private final MenuItemsImpl menuItems;

    @Override
    public List<MenuOption> getAvailableMenuOptions() {
        return menuItems.displayMenuItems().values().stream().collect(Collectors.toUnmodifiableList());
    }
}