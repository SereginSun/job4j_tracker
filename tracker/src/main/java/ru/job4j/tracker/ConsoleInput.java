package ru.job4j.tracker;

import java.util.Scanner;

public class ConsoleInput implements Input {
    private final Scanner scanner = new Scanner(System.in);

    @Override
    public String ask(String question) {
        System.out.println(question);
        return scanner.nextLine();
    }

    @Override
    public int ask(String question, UserAction[] actions) {
        int key = Integer.parseInt(ask(question));
        boolean exist = false;
        for (int i = 0; i < actions.length; i++) {
            if (i == key) {
                exist = true;
                break;
            }
        }
        if (!exist) {
            throw new MenuOutException("Out of menu range.");
        }
        return key;
    }
}
