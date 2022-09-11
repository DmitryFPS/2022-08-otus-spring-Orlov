package ru.spring.orlov.serviceImpl;

import org.springframework.stereotype.Service;
import ru.spring.orlov.service.IOService;

import java.io.PrintStream;
import java.util.Scanner;

@Service
public class IOServiceStreams implements IOService {
    private final PrintStream output;
    private final Scanner input;

    public IOServiceStreams() {
        this.output = System.out;
        this.input = new Scanner(System.in);
    }

    @Override
    public Scanner reader() {
        return input;
    }

    @Override
    public void outputString(String s) {
        output.println(s);
    }
}