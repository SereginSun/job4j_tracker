package ru.job4j.poly;

public class PolyUsage {
    public static void main(String[] args) {
        IAnimal cow = new Cow();
        IAnimal goose = new Goose();
        IAnimal dog = new Dog();
        IAnimal guineaPig = new GuineaPig();

        IAnimal[] animals = new IAnimal[] {cow, goose, dog, guineaPig};
        for (IAnimal animal : animals) {
            animal.sound();
        }
    }
}
