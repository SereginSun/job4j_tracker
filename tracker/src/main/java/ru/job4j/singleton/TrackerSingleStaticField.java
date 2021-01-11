package ru.job4j.singleton;

import ru.job4j.tracker.Tracker;

public class TrackerSingleStaticField {
    private static Tracker instance;

    private TrackerSingleStaticField() {
    }

    public static Tracker getInstance() {
        if (instance == null) {
            instance = new Tracker();
        }
        return instance;
    }
}
