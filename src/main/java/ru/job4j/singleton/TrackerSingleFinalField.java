package ru.job4j.singleton;

import ru.job4j.tracker.Tracker;

public class TrackerSingleFinalField {
    private static final Tracker INSTANCE = new Tracker();

    private TrackerSingleFinalField() {
    }

    public static Tracker getInstance() {
        return INSTANCE;
    }
}
