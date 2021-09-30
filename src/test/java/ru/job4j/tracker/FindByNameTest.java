package ru.job4j.tracker;

import org.junit.Test;

import java.time.format.DateTimeFormatter;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class FindByNameTest {
    private static final String LN = System.lineSeparator();
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");

    @Test
    public void whenFindItemByName() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Found item"));
        FindByName findByName = new FindByName(out);
        Input input = mock(Input.class);
        when(input.ask(anyString())).thenReturn("Found item");
        findByName.execute(input, tracker);
        assertThat(out.toString(),
                is(
                        "=== Finding Item by name ==="
                                + LN
                                + item.getId()
                                + ". "
                                + item.getName()
                                + "    "
                                + FORMATTER.format(item.getCreated())
                                + LN
                                + LN
                )
        );
    }

    @Test
    public void whenItemCannotBeFoundByName() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        tracker.add(new Item("Found item"));
        FindByName findByname = new FindByName(out);
        Input input = mock(Input.class);
        when(input.ask(anyString())).thenReturn("Some item");
        findByname.execute(input, tracker);
        assertThat(out.toString(),
                is(
                        "=== Finding Item by name ==="
                                + LN
                                + "No item found with the specified name."
                                + LN
                                + LN
                )
        );
    }
}