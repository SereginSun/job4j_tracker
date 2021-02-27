package ru.job4j.poly;

public class Animal {
    private final String nameClass = getClass().getSimpleName();

    public void sound() {
        System.out.println(nameClass + " - издаёт какой-то звук.");
    }

    public String getNameClass() {
        return nameClass;
    }
}
