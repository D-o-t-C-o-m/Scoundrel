package org.example;

import org.example.entities.Card;
import org.example.entities.Deck;
import org.example.entities.Player;
import org.example.enums.Suit;

import java.util.*;

public class UI {
private final List<Card> playfield;
private final List<Card> held;
private final List<Card> playfield2;
private final Deck deck;
private final Player player = new Player(20, 0);
private final Scanner scanner;
private final GameLogic gameLogic;
private boolean winState = false;
private boolean goodStart = false;
public int roomCount = 0;

public UI() {
	deck = new Deck();
	playfield = new ArrayList<>();
	held = new ArrayList<>();
	playfield2 = new ArrayList<>();
	scanner = new Scanner(System.in);
	gameLogic = new GameLogic(deck, player, this);
}

public void start() {
	deck.shuffle();
	firstRoom();
	//fillRoom();
	//nextRoom();
}

public void firstRoom() {
	while (!goodStart) {
		int size = 4;
		while (playfield.size() < size) {
			playfield.add(deck.dealCard());

		}
		int redCard = 0;
		int blackCard = 0;
		for (Card card : playfield) {
			if ((card.getSuit().equals(Suit.CUPS) || card.getSuit().equals(Suit.SWORDS))) {
				redCard++;
			} else if ((card.getSuit().equals(Suit.WANDS) || card.getSuit().equals(Suit.PENTACLES))) {
				blackCard++;
			}
		}
		if (redCard == 4 || blackCard == 4) {
			gameLogic.discard(playfield);
			deck.shuffle();
		} else {
			nextRoom();
			goodStart = true;
			roomCount++;
		}
	}
}

public void fillRoom() {
	int size = 4;
	int randomSize = roll1D6();
	if (randomSize == 1) {
		System.out.println("The next room feels different than the others");
		size = roll1D6() + 1;
	}
	int size2 = roll1D6();
	if (size2 == 1) {
		size2 += 1;
	}
	while (playfield.size() < size) {
		if (deck.isEmpty()) {
			handleFinalRoom();
			break;
		}
		playfield.add(deck.dealCard());

	}
	if (roll1D6() == 1) {
		while (playfield2.size() < size2) {
			if (deck.isEmpty()) {
				handleFinalRoom();
				break;
			}
			playfield2.add(deck.dealCard());

		}
		System.out.println("A branching path is before you.");
		roomChoice();
	}
}


public void holdItem(int index) {
	if (held.size() > 1) {
		System.out.println("You can only hold one item at a time.");
	} else {
		System.out.println("You have chosen to hold " + playfield.get(index - 1));
		held.add(playfield.get(index - 1));
		playfield.remove(index - 1);
	}
}

public void roomChoice() {
	System.out.println("One is filled with " + playfield.size() + " cards, the other with " + playfield2.size() + " cards.");
	System.out.println("Which room would you like to enter? (1) or (2) > ");
	int choice = -1;
	while (choice != 1 && choice != 2) {
		try {
			choice = scanner.nextInt();
			scanner.nextLine();
		} catch (InputMismatchException e) {
			System.out.println("Invalid input. Please enter a number (1 or 2).");
			scanner.nextLine();
			continue;
		}
		if (choice == 1) {
			gameLogic.discard(playfield2);
			break;
		} else if (choice == 2) {
			gameLogic.discard(playfield);
			playfield.addAll(playfield2);
			playfield2.clear();
			break;
		} else {
			System.out.println("Invalid choice. Please try again.");
		}
	}
}

public int roll1D6() {
	Random random = new Random();
	return random.nextInt(1, 7);
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
	roomCount++;
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
			//} else if (choice == 3){
			//	deck.getDiscards();
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

private void resetRoom() {
	player.setHasHealed(false);
	player.setHasFled(false);
	fillRoom();
	nextRoom();
}

private void checkWin() {
	System.out.println("/nYou have cleared the final obstacle and escaped the dungeon!");
	System.out.println("You have " + player.getCurrentHealth() + " health left.");
	System.out.println("You have " + player.getWeaponPower() + " attack power left.");
	int score = deck.score() + player.getCurrentHealth() + player.getWeaponPower()+ roomCount;
	System.out.println("Your final score is: " + score);
	System.exit(0);
}

public List<Card> getPlayfield() {
	return playfield;
}

}