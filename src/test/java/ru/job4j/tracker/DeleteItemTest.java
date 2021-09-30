package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class DeleteItemTest {
    private static final String LN = System.lineSeparator();

    @Test
    public void whenDeletedItem() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        tracker.add(new Item("Deleted Item"));
        DeleteItem delete = new DeleteItem(out);
        Input input = mock(Input.class);
        when(input.ask(anyString())).thenReturn("1");
        delete.execute(input, tracker);
        assertThat(out.toString(),
                is("=== Deleting an Item ==="
                        + LN
                        + "The item has been successfully deleted."
                        + LN
                        + LN
                )
        );
        assertNull(tracker.findById(1));
    }

    @Test
    public void whenDontDeletedItem() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        tracker.add(new Item("Deleted Item"));
        DeleteItem delete = new DeleteItem(out);
        Input input = mock(Input.class);
        when(input.ask(anyString())).thenReturn("2");
        delete.execute(input, tracker);
        assertThat(out.toString(),
                is("=== Deleting an Item ==="
                        + LN
                        + "No item found with the specified ID."
                        + LN
                        + LN
                )
        );
        assertThat(tracker.findById(1).getName(), is("Deleted Item"));
    }
}