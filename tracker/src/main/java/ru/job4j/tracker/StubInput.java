package ru.job4j.tracker;

import java.util.List;

public class StubInput implements Input {
    private final String[] answers;
    private int position = 0;

    public StubInput(String[] answers) {
        this.answers = answers;
    }

    @Override
    public String ask(String question) {
        return answers[position++];
    }

    @Override
    public int ask(String question, List<UserAction> actions) {
        int key = Integer.parseInt(ask(question));
        boolean exist = false;
        for (int i = 0; i < actions.size(); i++) {
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
