package ru.job4j.singleton;

import org.junit.Test;
import ru.job4j.tracker.Tracker;

import static org.junit.Assert.*;

public class TrackerSingleTest {

    @Test
    public void whenTrackerSingleEnum() {
        TrackerSingleEnum tracker1 = TrackerSingleEnum.INSTANCE;
        TrackerSingleEnum tracker2 = TrackerSingleEnum.INSTANCE;
        assertSame(tracker1, tracker2);
    }

    @Test
    public void whenTrackerSingleFinalField() {
        Tracker tracker1 = TrackerSingleFinalField.getInstance();
        Tracker tracker2 = TrackerSingleFinalField.getInstance();
        assertSame(tracker1, tracker2);
    }

    @Test
    public void whenTrackerSingleStaticField() {
        Tracker tracker1 = TrackerSingleStaticField.getInstance();
        Tracker tracker2 = TrackerSingleStaticField.getInstance();
        assertSame(tracker1, tracker2);
    }

    @Test
    public void whenTrackerSingleStaticFinalClass() {
        Tracker tracker1 = TrackerSingleStaticFinalClass.getInstance();
        Tracker tracker2 = TrackerSingleStaticFinalClass.getInstance();
        assertSame(tracker1, tracker2);
    }
}