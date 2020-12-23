package ru.job4j.poly;

public class LogisticCenter {
    public static void main(String[] args) {
        Vehicle aircraft = new Plane();
        Vehicle redArrow = new Train();
        Vehicle yacht = new Boat();
        Vehicle[] transports = new Vehicle[] {aircraft, redArrow, yacht};
        for (Vehicle transport : transports) {
            transport.move();
        }

    }
}
