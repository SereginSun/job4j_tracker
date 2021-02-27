package ru.job4j.oop;

public class Student {

    public void music(String lyrics) {
        System.out.println("I can sing a song: " + lyrics);
    }

    public void song() {
        System.out.println("I believe I can fly");
    }

    public static void main(String[] args) {
        Student petr = new Student();
        String lyrics = "I believe I can fly";
        petr.music(lyrics);
        petr.song();
        petr.song();
        petr.song();
    }
}
