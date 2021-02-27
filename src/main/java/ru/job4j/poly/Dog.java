package ru.job4j.poly;

public class Dog implements IAnimal {

    @Override
    public void sound() {
        System.out.println(getClass().getSimpleName() + " произносит звук ГАВ-ГАВ.");
    }
}
