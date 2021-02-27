package ru.job4j.poly;

public class Goose implements IAnimal {

    @Override
    public void sound() {
        System.out.println(getClass().getSimpleName() + " произносит звук ГА-ГА.");
    }
}
