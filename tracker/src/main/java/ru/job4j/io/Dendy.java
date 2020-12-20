package ru.job4j.io;

import java.util.Scanner;

public class Dendy {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean run = true;
        while (run) {
            System.out.println("Games:");
            System.out.println("1. Tanks.");
            System.out.println("2. Super Mario.");
            System.out.println("3. Exit.");
            System.out.println("Enter the menu item to start the game: ");
            int select = Integer.parseInt(input.nextLine());
            switch (select) {
                case 3:
                    System.out.println("The game is over.");
                    run = false;
                    break;
                case 1:
                    System.out.println("Tanks are loading...");
                    break;
                case 2:
                    System.out.println("Super Mario are loading...");
                    break;
                default:
                    System.out.println("There is no such game.");
                    break;
            }
            System.out.println();
        }
    }
}
