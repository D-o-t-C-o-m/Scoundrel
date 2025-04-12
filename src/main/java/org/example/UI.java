package org.example;

import org.example.entities.Card;
import org.example.entities.Deck;
import org.example.entities.Player;

import java.util.*;

public class UI {
private final List<Card> playfield;
private final Deck deck;
private final Player player = new Player(20, 0);
private final Scanner scanner;
private final GameLogic gameLogic;
private boolean winState = false;

public UI() {
	deck = new Deck();
	playfield = new ArrayList<>();
	scanner = new Scanner(System.in);
	gameLogic = new GameLogic(deck, player, this);
}

public void start() {
	deck.shuffle();
	fillRoom();
	nextRoom();
}

public void fillRoom() {
	while (playfield.size() < 4) {
		if (deck.isEmpty()) {
			handleFinalRoom();
			break;
		}
		playfield.add(deck.dealCard());
	}
}

private void handleFinalRoom() {
	System.out.println("You sense that this is the final room.");
	winState = true;
}

public void displayPlayfield() {
	getPlayerStats();
	System.out.println("---------------------------------------");
	System.out.println(" " + playfield + "\n");
}

private void getPlayerStats() {
	System.out.println("\nHealth Points: " + player.getCurrentHealth() + "/ " + player.getMaxHealth() + " | Attack Power: " + player.getWeaponPower() + " | " + "Remaining Obstacles: " + deck.cardsLeft());
}

public void nextRoom() {
	displayPlayfield();
	int choice = -1;
	while (choice != 1 && choice != 2) {
		System.out.print("You are standing in the door to a room. Do you (1) Enter or (2) Flee? > ");
		try {
			choice = scanner.nextInt();
			scanner.nextLine();
		} catch (InputMismatchException e) {
			System.out.println("Invalid input. Please enter a number (1 or 2).");
			scanner.nextLine();
			continue;
		}

		if (choice == 1) {
			System.out.println("You step forth");
			player.hasFled = false;
			enter();
		} else if (choice == 2) {
			if (player.hasFled) {
				System.out.println("You cannot flee again, you must go forward.");
				displayPlayfield();
				enter();
			}
			gameLogic.flee();
		} else {
			System.out.println("Invalid choice. Please try again.");
			displayPlayfield();
		}
	}
}

public int getAttackChoice() {
	int choice;
	while (true) {
		System.out.print("How will you attack? (1) Bare-Handed or (2) With a Weapon? > ");
		try {
			choice = scanner.nextInt();
			scanner.nextLine();
		} catch (InputMismatchException e) {
			System.out.println("Invalid input. Please enter 1 or 2.");
			scanner.nextLine();
			continue;
		}
		if (choice == 1 || choice == 2) {
			break;
		} else {
			System.out.println("Invalid choice. Please enter 1 or 2.");
		}
	}
	return choice;
}

private void enter() {
	displayPlayfield();
	while (playfield.size() > 1) {
		System.out.print("Which card would you like to interact with? (1-" + playfield.size() + ") > ");
		int choice;
		try {
			choice = scanner.nextInt();
			scanner.nextLine();
		} catch (InputMismatchException e) {
			System.out.println("Invalid input. Please enter a number between 1 and " + playfield.size() + ".");
			scanner.nextLine();
			continue;
		}

		if (choice >= 1 && choice <= playfield.size()) {
			gameLogic.handleCardInteraction(playfield.get(choice - 1));
		} else {
			System.out.println("Invalid choice. Please try again.");
		}
		displayPlayfield();
	}
	if (winState) {
		int choice = 0;
		try {
			System.out.print("Which card would you like to interact with? (1) > ");
			choice = scanner.nextInt();
			scanner.nextLine();
		} catch (InputMismatchException e) {
			System.out.println("Invalid input. Please enter a number 1 and embrace your fate.");
			scanner.nextLine();
		}

		if (choice == 1) {
			gameLogic.handleCardInteraction(playfield.getFirst());
			checkWin();
		} else {
			System.out.println("Invalid choice. Please try again.");
		}

	}
	System.out.println("Room cleared, you can now leave.\n");
	resetRoom();
}

private void resetRoom(){
	player.setHasHealed(false);
	player.setHasFled(false);
	fillRoom();
	nextRoom();
}

private void checkWin() {
	System.out.println("/nYou have cleared the final obstacle and escaped the dungeon!");
	System.out.println("You have " + player.getCurrentHealth() + " health left.");
	System.out.println("You have " + player.getWeaponPower() + " attack power left.");
	int score = deck.score() + player.getCurrentHealth() + player.getWeaponPower();
	System.out.println("Your final score is: " + score);
	System.exit(0);
}

public List<Card> getPlayfield() {
	return playfield;
}

}