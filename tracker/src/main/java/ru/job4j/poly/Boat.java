package ru.job4j.poly;

public class Boat implements Vehicle {
    @Override
    public void move() {
        System.out.println(getClass().getSimpleName() + " floats on water.");
    }
}
