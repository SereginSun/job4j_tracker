package ru.job4j.poly;

public interface Transport {

    void go();

    void passengers(int numOfPass);

    double fill(double fuel);
}
