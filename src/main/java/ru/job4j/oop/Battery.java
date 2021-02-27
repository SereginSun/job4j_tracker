package ru.job4j.oop;

public class Battery {
    private int load;

    public Battery(int load) {
        this.load = load;
    }

    public void exchange(Battery another) {
        another.load += this.load;
        this.load = 0;
    }

    public static void main(String[] args) {
        Battery first = new Battery(10);
        Battery second = new Battery(5);
        System.out.printf("first: %d    second: %d%n", first.load, second.load);
        first.exchange(second);
        System.out.printf("first: %d    second: %d%n", first.load, second.load);
    }
}
