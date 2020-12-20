package ru.job4j.io;

import java.util.Scanner;

public class Matches {
    public static void main(String[] args) {
        System.out.println("There are 11 matches on the table.");
        System.out.println("Two players take turns taking 1 to 3 matches.");
        System.out.println("The winner is the one who took the last matches.");
        Scanner input = new Scanner(System.in);
        int matches = 11;
        boolean winner = true;
        String username = "";
        while (matches > 0) {
            username = winner ? "First player" : "Second player";
            System.out.printf("%s, enter the number of matches: %n", username);
            int select = input.nextInt();
            if (select > 0 && select < 4 && select <= matches) {
                matches -= select;
                if (matches > 0) {
                    System.out.printf("%s matches left on the table.%n", matches);
                    winner = !winner;
                }
            } else {
                System.out.println("Enter a number between 1 and 3.");
                System.out.println("Or less than the remaining number of matches.");
            }
        }
        System.out.printf("%s is winner!%n", username);
    }
}
