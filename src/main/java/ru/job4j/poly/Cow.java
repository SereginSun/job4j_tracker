package ru.job4j.poly;

public class Cow implements IAnimal {

    @Override
    public void sound() {
        System.out.println(getClass().getSimpleName() + " произносит звук МУ-МУ.");
    }
}
