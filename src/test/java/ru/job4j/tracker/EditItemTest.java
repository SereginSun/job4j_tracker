package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class EditItemTest {
    private static final String LN = System.lineSeparator();

    @Test
    public void whenReplacedItem() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        tracker.add(new Item("Replaced item"));
        String replacedName = "New item name";
        EditItem replace = new EditItem(out);
        Input input = mock(Input.class);
        when(input.ask(anyString())).thenReturn("1", replacedName);
        replace.execute(input, tracker);
        assertThat(out.toString(),
                is("=== Editing an Item ==="
                        + LN
                        + "The item has been successfully edited."
                        + LN
                        + LN
                )
        );
        assertThat(tracker.findAll().get(0).getName(), is(replacedName));
    }

    @Test
    public void whenDontReplacedItem() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        tracker.add(new Item("Replaced item"));
        String replacedName = "New item name";
        EditItem replace = new EditItem(out);
        Input input = mock(Input.class);
        when(input.ask(anyString())).thenReturn("2", replacedName);
        replace.execute(input, tracker);
        assertThat(out.toString(),
                is("=== Editing an Item ==="
                        + LN
                        + "No item found with the specified ID."
                        + LN
                        + LN
                )
        );
        assertThat(tracker.findAll().get(0).getName(), is("Replaced item"));
    }

}