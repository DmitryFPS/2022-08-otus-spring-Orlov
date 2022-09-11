package ru.spring.orlov.service;

import java.util.Scanner;

public interface IOService {
    Scanner reader();

    void outputString(String s);
}