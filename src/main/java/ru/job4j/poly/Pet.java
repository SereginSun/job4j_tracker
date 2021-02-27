package ru.job4j.poly;

public class Pet extends Animal {
    public void vaccinate() {
        System.out.println(getNameClass() + " нуждается в прививках, чтобы не болеть.");
    }
}
