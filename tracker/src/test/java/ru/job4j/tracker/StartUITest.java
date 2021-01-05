package ru.job4j.tracker;

import org.junit.Test;

import java.time.format.DateTimeFormatter;

import static org.hamcrest.Matchers.nullValue;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class StartUITest {
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");
    private static final String LN = System.lineSeparator();

    @Test
    public void whenAddItem() {
        String[] answers = {"0", "Fix PC", "1"};
        Input in = new StubInput(answers);
        Tracker tracker = new Tracker();
        Output out = new StubOutput();
        UserAction[] actions = {
                new CreateItem(out),
                new ExitAction()
        };
        new StartUI(out).init(in, tracker, actions);
        Item created = tracker.findAll()[0];
        Item expected = new Item("Fix PC");
        assertThat(created.getName(), is(expected.getName()));
    }

    @Test
    public void whenReplaceItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("new Item");
        tracker.add(item);
        String[] answers = {"0", String.valueOf(item.getId()), "replaced item", "1"};
        Input in = new StubInput(answers);
        Output out = new StubOutput();
        UserAction[] actions = {
                new EditItem(out),
                new ExitAction()
        };
        new StartUI(out).init(in, tracker, actions);
        Item replaced = tracker.findById(item.getId());
        assertThat(replaced.getName(), is("replaced item"));
    }

    @Test
    public void whenDeleteItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("new Item");
        tracker.add(item);
        String[] answers = {"0", String.valueOf(item.getId()), "1"};
        Input in = new StubInput(answers);
        Output out = new StubOutput();
        UserAction[] actions = {
                new DeleteItem(out),
                new ExitAction()
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()), is(nullValue()));
    }

    @Test
    public void whenExit() {
        Output out = new StubOutput();
        String[] answers = {"0"};
        Input in = new StubInput(answers);
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new ExitAction()
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                "Menu." + LN
                + "0. Exit." + LN
                + System.lineSeparator()
        ));
    }

    @Test
    public void whenFindAllItems() {
        Output out = new StubOutput();
        String[] answers = {"0", "1"};
        Input in = new StubInput(answers);
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new ShowAllItems(out),
                new ExitAction()
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                "Menu." + LN
                        + "0. Show all Items." + LN
                        + "1. Exit." + LN + LN
                        + "=== Show all Items.===" + LN
                        + "No items" + LN + LN
                        + "Menu." + LN
                        + "0. Show all Items." + LN
                        + "1. Exit." + LN + LN
        ));
    }

    @Test
    public void whenFindByName() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item firstItem = new Item("Bug");
        tracker.add(firstItem);
        String[] answers = {"0", firstItem.getName(), "1"};
        Input in = new StubInput(answers);
        UserAction[] actions = {
                new FindByName(out),
                new ExitAction()
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                "Menu." + LN
                        + "0. Find Items by name." + LN
                        + "1. Exit." + LN + LN
                        + "=== Finding Item by name ===" + LN
                        + firstItem.getId() + ". " + firstItem.getName() + "    "
                        + FORMATTER.format(firstItem.getCreated()) + LN + LN
                        + "Menu." + LN
                        + "0. Find Items by name." + LN
                        + "1. Exit." + LN + LN
        ));
    }

    @Test
    public void whenFindByID() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item firstItem = new Item("Bug");
        tracker.add(firstItem);
        String[] answers = {"0", String.valueOf(firstItem.getId()), "1"};
        Input in = new StubInput(answers);
        UserAction[] actions = {
                new FindById(out),
                new ExitAction()
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                "Menu." + LN
                        + "0. Find Item by ID." + LN
                        + "1. Exit." + LN + LN
                        + "=== Finding Item by ID ===" + LN
                        + firstItem.getId() + ". " + firstItem.getName() + "    "
                        + FORMATTER.format(firstItem.getCreated()) + LN + LN
                        + "Menu." + LN
                        + "0. Find Item by ID." + LN
                        + "1. Exit." + LN + LN
        ));
    }
}