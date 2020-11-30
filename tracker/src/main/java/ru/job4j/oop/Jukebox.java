package ru.job4j.oop;

public class Jukebox {

    public void music(int position) {
        if (position == 1) {
            System.out.println("First song.");
        } else if (position == 2) {
            System.out.println("Second song.");
        } else {
            System.out.println("The song was not found.");
        }
    }

    public static void main(String[] args) {
        Jukebox aJukebox = new Jukebox();
        aJukebox.music(2);
        aJukebox.music(5);
        aJukebox.music(1);
    }
}
