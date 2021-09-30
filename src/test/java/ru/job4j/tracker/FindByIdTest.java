package ru.job4j.tracker;

import org.junit.Test;

import java.time.format.DateTimeFormatter;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class FindByIdTest {
    private static final String LN = System.lineSeparator();
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");

    @Test
    public void whenFindItemById() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Found item"));
        FindById findById = new FindById(out);
        Input input = mock(Input.class);
        when(input.ask(anyString())).thenReturn("1");
        findById.execute(input, tracker);
        assertThat(out.toString(),
                is(
                        "=== Finding Item by ID ==="
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
    public void whenItemCannotBeFoundById() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        tracker.add(new Item("Found item"));
        FindById findById = new FindById(out);
        Input input = mock(Input.class);
        when(input.ask(anyString())).thenReturn("2");
        findById.execute(input, tracker);
        assertThat(out.toString(),
                is(
                        "=== Finding Item by ID ==="
                                + LN
                                + "No item found with the specified ID."
                                + LN
                                + LN
                )
        );
    }
}