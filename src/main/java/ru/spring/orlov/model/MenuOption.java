package ru.spring.orlov.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
@EqualsAndHashCode(exclude = "id")
public class MenuOption {
    private final int id;
    private final String description;

    @Override
    public String toString() {
        return id + " " + description;
    }
}