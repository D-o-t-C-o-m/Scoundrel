package org.example;

import org.example.entities.Card;
import org.example.entities.Deck;
import org.example.entities.Player;
import org.example.enums.Suit;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;


public class UI {
private final List<Card> playfield;
private final Deck deck;
private final Player player = new Player(20, 0);;
private final List<Card> weapons;
private final Scanner scanner;
private int EnemyHealth;

public UI() {
	deck = new Deck();
	playfield = new ArrayList<>();
	Player player = this.player;
	weapons = new ArrayList<>();
	scanner = new Scanner(System.in);
	EnemyHealth = 0;
}

public void start() {
	deck.shuffle();
	fillRoom();
	nextRoom();
}

public void fillRoom() {
	while (playfield.size() < 4) {
		playfield.add(deck.dealCard());
	}
}
public void getPlayer(){
	System.out.println("Health Points: "+ player.getCurrentHealth()+ "/ "+ player.getMaxHealth() + " Attack Power: " + player.getWeaponPower());
}
public void displayPlayfield() {
	getPlayer();
	System.out.println(playfield.toString());
}
public void nextRoom() {
	getPlayer();
	System.out.println(playfield.toString());
	System.out.print("You are standing in the door to a room. Do you (1) Enter or (2) Flee? > " );
	int choice = scanner.nextInt();
	scanner.nextLine();

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
public void flee(){
	System.out.println("You have fled the room.");
	player.setHasFled(true);

	Iterator<Card> iterator = playfield.iterator();
	while (iterator.hasNext()) {
		Card card = iterator.next();
		deck.add(card);
		iterator.remove();
	}
	deck.shuffle();
	fillRoom();
	nextRoom();
}
public void enter() {
	getPlayer();
	while (playfield.size() > 1) {
		System.out.print("Which card would you like to interact with? (1-" + playfield.size() + ") > ");
		int choice = scanner.nextInt();
		scanner.nextLine();
		switch (choice) {
			case 1 -> suitFunctions(playfield.get(0));
			case 2 -> suitFunctions(playfield.get(1));
			case 3 -> suitFunctions(playfield.get(2));
			case 4 -> suitFunctions(playfield.get(3));
			default -> System.out.println("Invalid choice. Please try again.");
		}
		displayPlayfield();
	}
		System.out.println("Room cleared, you can now leave.");
		player.setHasHealed(false);
		fillRoom();
		nextRoom();

}

public void suitFunctions (Card card) {
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
			System.out.println("You approach the enemy.");
			EnemyHealth = card.getValue();
			System.out.println("How will you attack? (1) Bare-Handed or (2) With a Weapon? > ");
			int choice = scanner.nextInt();
			scanner.nextLine();
			if (choice == 1) {
				System.out.println("You attack the enemy with your bare hands.");
				player.setAttackPower(EnemyHealth);
				int damage = player.getCurrentHealth() - card.getValue();
				player.setCurrentHealth(damage);
				if (player.getCurrentHealth() <= 0) {
					System.out.println("You have been defeated.");
					System.exit(0);
					break;
				} else {
					System.out.println("You have " + player.getCurrentHealth() + " health left.");
				}
				playfield.remove(card);

			} else if (choice == 2) {
				System.out.println("You attack the enemy with a weapon.");
				if (player.getWeaponPower() > EnemyHealth) {
					System.out.println("You have defeated the enemy, and your weapon is now weaker.");
					player.setWeaponPower(EnemyHealth);
					playfield.remove(card);
					break;
				} else if (player.getWeaponPower() == EnemyHealth) {
					System.out.println("You have defeated the enemy.");
					playfield.remove(card);
					break;
				} else if (player.getWeaponPower() < EnemyHealth) {
					int damage = card.getValue() - player.getWeaponPower();
					player.setCurrentHealth(player.getCurrentHealth() - damage);
					if (player.getCurrentHealth() <= 0) {
						System.out.println("You have been defeated.");
						System.exit(0);
						break;
					} else {
						System.out.println("You have defeated the enemy, but you took some damage.");
						System.out.println("You have " + player.getCurrentHealth() + " health left.");
					}
					playfield.remove(card);
					break;
				} else {
					System.out.println("Invalid choice. Please try again.");
				}
			}
		}
		case DIAMONDS -> {
			weapons.clear();
			player.setWeaponPower(card.getValue());
			weapons.add(card);
			playfield.remove(card);
			System.out.println("You have found a weapon! Your attack power is now: " + player.getWeaponPower());
			break;
		}
	}
}
}