package ru.job4j.tracker;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ValidateInputTest {

    @Test
    public void whenInvalidInput() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"one", "1"}
        );
        ValidateInput input = new ValidateInput(out, in);
        List<UserAction> actions = new ArrayList<>();
        actions.add(new FindByName(out));
        actions.add(new ExitAction());
        int selected = input.ask("Enter menu:", actions);
        assertThat(out.toString(), is(
                "Please enter validate data again."
                + System.lineSeparator() + System.lineSeparator()
        ));
        assertThat(selected, is(1));
    }

    @Test
    public void whenMultipleCorrectInput() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"0", "1", "2"}
        );
        ValidateInput input = new ValidateInput(out, in);
        List<UserAction> actions = new ArrayList<>();
        actions.add(new CreateItem(out));
        actions.add(new FindByName(out));
        actions.add(new ExitAction());
        int firstSelected = input.ask("Enter menu:", actions);
        assertThat(firstSelected, is(0));
        int secondSelected = input.ask("Enter menu:", actions);
        assertThat(secondSelected, is(1));
        int thirdSelected = input.ask("Enter menu:", actions);
        assertThat(thirdSelected, is(2));
    }

    @Test
    public void whenNegativeInput() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"4", "-1", "1"}
        );
        ValidateInput input = new ValidateInput(out, in);
        List<UserAction> actions = new ArrayList<>();
        actions.add(new CreateItem(out));
        actions.add(new FindByName(out));
        actions.add(new ExitAction());
        int selected = input.ask("Enter menu:", actions);
        assertThat(selected, is(1));
    }
}