package ru.job4j.tracker;

import java.util.List;

public class ValidateInput implements Input {
    private final Output out;
    private final Input in;

    public ValidateInput(Output out, Input in) {
        this.out = out;
        this.in = in;
    }

    @Override
    public String ask(String question) {
        return in.ask(question);
    }

    @Override
    public int ask(String question, List<UserAction> actions) {
        boolean invalid = true;
        int value = -1;
        do {
            try {
                value = in.ask(question, actions);
                invalid = false;
            } catch (NumberFormatException nfe) {
                out.println("Please enter validate data again.");
                out.println("");
            } catch (MenuOutException moe) {
                out.println("Please enter the item number from the menu.");
                out.println("");
            }
        } while (invalid);
        return value;
    }
}
