package org.example;

import org.example.entities.Card;
import org.example.entities.Deck;
import org.example.entities.Player;
import org.example.enums.Suit;
import java.util.*;

public class UI {
private final List<Card> playfield;
private final Deck deck;
private final Player player = new Player(20, 0);
final Scanner scanner;
private int EnemyHealth;
private String EnemyName;
private boolean winState = false;
private int score;

public UI() {
	deck = new Deck();
	playfield = new ArrayList<>();
	scanner = new Scanner(System.in);
	EnemyHealth = 0;
	EnemyName = "";
	score = deck.score();
}

public void start() {
	deck.shuffle();
	deck.shuffle();
	fillRoom();
	nextRoom();
}

private void fillRoom() {
	while (playfield.size() < 4) {
		if (deck.isEmpty()) {
			System.out.println("You sense that this is the final room.");
			winState = true;
			if (playfield.size()==1) {
				break;
			}
			break;
		}
		playfield.add(deck.dealCard());
	}
}

private void getPlayer() {
	System.out.println("\nHealth Points: " + player.getCurrentHealth() + "/ " + player.getMaxHealth() + " | Attack Power: " + player.getWeaponPower());
}

private void displayPlayfield() {
	getPlayer();
	System.out.println(" ----------------------------------");
	System.out.println("       "+playfield + "\n");
}

private void nextRoom() {
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
			nextRoom();
			return;
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
			flee();
		} else {
			System.out.println("Invalid choice. Please try again.");
			displayPlayfield();
		}
	}
}

private void flee() {
	System.out.println("You have fled the room.");
	player.setHasFled(true);

	Iterator<Card> iterator = playfield.iterator();
	while (iterator.hasNext()) {
		Card card = iterator.next();
		deck.addToFront(card);
		iterator.remove();
	}
	//deck.shuffle();
	fillRoom();
	nextRoom();
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
				suitFunctions(playfield.get(choice - 1));
			} else {
				System.out.println("Invalid choice. Please try again.");
			}
			displayPlayfield();
		}
		if (winState) {
			int choice = 0;
			try {
				System.out.println(">");
				choice = scanner.nextInt();
				scanner.nextLine();
			} catch (InputMismatchException e) {
				System.out.println("Invalid input. Please enter a number 1");
				scanner.nextLine();
			}

			if (choice == 1) {
				suitFunctions(playfield.getFirst());
				checkWin();
			} else {
				System.out.println("Invalid choice. Please try again.");
			}

		}
		System.out.println("Room cleared, you can now leave.\n");
		player.setHasHealed(false);
		player.setHasFled(false);
		fillRoom();
		nextRoom();
	}

private void suitFunctions(Card card) {
	Suit suit = card.getSuit();
	switch (suit) {
		case HEARTS -> {
			if (!player.hasHealed()) {
				player.setCurrentHealth(player.getCurrentHealth() + card.getValue());
				if (player.getCurrentHealth() > player.getMaxHealth()) {
					player.setCurrentHealth(player.getMaxHealth());
				}
				player.setHasHealed(true);
				playfield.remove(card);
				System.out.println("You have healed yourself. Current health: " + player.getCurrentHealth());
			} else {
				System.out.println("You have already healed yourself in this room.");
				playfield.remove(card);
			}
		}
		case SPADES, CLUBS -> {
			EnemyName = card.toString();
			System.out.println("You approach " + EnemyName + ".");
			EnemyHealth = card.getValue();
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

			if (choice == 1) {
				System.out.println("You attack the enemy with your bare hands.");
				player.setAttackPower(EnemyHealth);
				int damage = player.getCurrentHealth() - card.getValue();
				player.setCurrentHealth(damage);
				if (player.getCurrentHealth() <= 0) {
					System.out.println("You have been defeated.");
					score = deck.score() + player.getCurrentHealth() + player.getWeaponPower();
					System.out.println("Your final score is: " + score);
					System.exit(0);
				} else {
					System.out.println("You have " + player.getCurrentHealth() + " health left.");
				}
				playfield.remove(card);
			} else {
				System.out.println("You attack the enemy with a weapon.");
				if (player.getWeaponPower() > EnemyHealth) {
					System.out.println("You have defeated the enemy, and your weapon is now weaker.");
					player.setWeaponPower(EnemyHealth);
					playfield.remove(card);
				} else if (player.getWeaponPower() == EnemyHealth) {
					System.out.println("You have defeated the enemy.");
					playfield.remove(card);
				} else if (player.getWeaponPower() < EnemyHealth) {
					int damage = card.getValue() - player.getWeaponPower();
					player.setCurrentHealth(player.getCurrentHealth() - damage);
					if (player.getCurrentHealth() <= 0) {
						System.out.println("You have been defeated.");
						score = deck.score() + player.getCurrentHealth() + player.getWeaponPower();
						System.out.println("Your final score is: " + score);
						System.exit(0);
					} else {
						System.out.println("You have defeated the enemy, but you took some damage.");
						System.out.println("You have " + player.getCurrentHealth() + " health left.");
					}
					playfield.remove(card);
				}
			}
		}
		case DIAMONDS -> {
			player.setWeaponPower(card.getValue());
			playfield.remove(card);
			System.out.println("You have found a weapon! Your attack power is now: " + player.getWeaponPower());
		}
	}
}

private void checkWin() {
		System.out.println("You have cleared the final obstacle and escaped the dungeon!");
		System.out.println("You have " + player.getCurrentHealth() + " health left.");
		System.out.println("You have " + player.getWeaponPower() + " attack power left.");
		score = deck.score() + player.getCurrentHealth() + player.getWeaponPower();
		System.out.println("Your final score is: " + score);
		System.exit(0);
	}
}
