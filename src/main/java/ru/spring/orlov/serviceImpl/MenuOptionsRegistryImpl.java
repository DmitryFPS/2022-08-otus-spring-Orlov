package ru.spring.orlov.serviceImpl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.spring.orlov.model.MenuOption;
import ru.spring.orlov.service.MenuOptionsRegistry;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MenuOptionsRegistryImpl implements MenuOptionsRegistry {
    private final MenuItemsImpl menuItems;

    @Override
    public List<MenuOption> getAvailableMenuOptions() {
        return new ArrayList<>(menuItems.displayMenuItems());
    }
}