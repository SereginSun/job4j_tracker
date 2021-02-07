package ru.job4j.tracker;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static java.util.Collections.sort;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ItemTest {

    @Test
    public void whenAscendingSort() {
        List<Item> items = Arrays.asList(
          new Item(2, "Fix bugs"),
          new Item(1, "Impl task"),
          new Item(3, "Reboot server")
        );
        sort(items);
        assertThat(items.get(0).getName(), is("Impl task"));
    }

    @Test
    public void whenDescendingSort() {
        List<Item> items = Arrays.asList(
                new Item(2, "Fix bugs"),
                new Item(1, "Impl task"),
                new Item(3, "Reboot server")
        );
        items.sort(new SortByIdItemReverse());
        assertThat(items.get(0).getName(), is("Reboot server"));
    }
}