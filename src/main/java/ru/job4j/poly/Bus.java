package ru.job4j.poly;

public class Bus implements Transport {

    @Override
    public void go() {
        System.out.println("The bus travels from point A to point B.");
    }

    @Override
    public void passengers(int numOfPass) {
        System.out.printf("The bus carries %d passengers.%n", numOfPass);
    }

    @Override
    public double fill(double fuel) {
        double price = 49.50;
        return price * fuel;
    }

    public static void main(String[] args) {
        Bus shuttle = new Bus();
        shuttle.passengers(50);
        shuttle.go();
        shuttle.fill(35);
    }
}
