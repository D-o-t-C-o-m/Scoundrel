package org.example;

import org.example.entities.Player;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputHandler {
private final Scanner scanner;

public InputHandler() {
    this.scanner = new Scanner(System.in);
}

public int getNumericChoice(String prompt, int min, int max) {
    System.out.print(prompt);
    while (true) {
        try {
            int choice = scanner.nextInt();
            scanner.nextLine();
            if (choice >= min && choice <= max) {
                return choice;
            } else {
                System.out.println("Invalid choice. Please enter a number between " + min + " and " + max + ".");
                System.out.print(prompt);
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a number.");
            scanner.nextLine();
            System.out.print(prompt);
        }
    }
}

public boolean getYesNoChoice(String prompt) {
    System.out.print(prompt + " (y/n): ");
    while (true) {
        String input = scanner.nextLine().trim().toLowerCase();
        if (input.equals("y") || input.equals("yes")) {
            return true;
        } else if (input.equals("n") || input.equals("no")) {
            return false;
        } else {
            System.out.println("Invalid input. Please enter 'y' or 'n'.");
            System.out.print(prompt + " (y/n): ");
        }
    }
}


public int getRoomChoice(int playfield1Size, int playfield2Size) {
    String prompt = String.format("One is filled with %d cards, the other with %d cards.\n" +
                    "Which room would you like to enter? (1) or (2) > ",
            playfield1Size, playfield2Size);
    return getNumericChoice(prompt, 1, 2);
}

public int getCardChoice(int maxCards) {
    String prompt = "Which card would you like to interact with? (1-" + maxCards + ") > ";
    return getNumericChoice(prompt, 1, maxCards);
}

public int getRoomEntryChoice() {
    String prompt = "You are standing in the door to a room. Do you (1) Enter or (2) Flee? > ";
    return getNumericChoice(prompt, 1, 2);
}

public int getCombatChoice() {
        String prompt = "How will you attack? (1) Bare-Handed, (2) With a Weapon, or (3) Use Item > ";
        return getNumericChoice(prompt, 1, 3);

}

public int getRulesChoice() {
    String prompt = "Do you want to play with the (1) Original weapon rules or the (2) New rules?\n> ";
    return getNumericChoice(prompt, 1, 2);
}

public int getMenuChoice() {
    System.out.println("Welcome, Hea\uD801\uDD63hen. Would you like to Read the rules, or Begin?");
    System.out.println("1. Read the rules");
    System.out.println("2. Begin");
    return getNumericChoice("> ", 1, 2);
}

}