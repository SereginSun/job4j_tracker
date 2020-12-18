package ru.job4j.io;

import java.util.Random;
import java.util.Scanner;

public class MagicBall {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("I am the great Oracle. What do you want to know?");
        input.nextLine();
        int answer = new Random().nextInt(3);
        String result;
        switch (answer) {
            case 1:
                result = "Yes";
                break;
            case 2:
                result = "No";
                break;
            default:
                result = "Maybe";
        }
        System.out.println(result);
    }
}
