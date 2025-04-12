package org.example;

import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

public class Main {
public static void main(String[] args) throws IOException {
	System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8));
	UI ui = new UI();
	int choice;
	System.out.println("Welcome, Scoundrel. Would you like to Read the rules, or Begin?");
	System.out.println("1. Read the rules");
	System.out.println("2. Begin");
	System.out.print("> ");
	choice = ui.scanner.nextInt();
	ui.scanner.nextLine();
	while (choice != 1 && choice != 2) {
		System.out.println("Invalid Option. Please try again.\n");
		System.out.println("1. Read the rules");
		System.out.println("2. Begin");
		System.out.print("> ");
		choice = ui.scanner.nextInt();
		ui.scanner.nextLine();
	}
	if (choice == 1) {
		System.out.println();
		System.out.println("Welcome to Scoundrel, a card game where you play as a scoundrel trying to escape a dungeon. You will face monsters and collect weapons and potions to survive.\nThis game was created by Zach Gage and Kurt Bieg.\n");

		System.out.println("Goal: Clear the deck. You lose if your health hits 0.\nRooms: Each room is 4 cards. Choose 3 in any order. Once one card is left the room is clear, and 3 new cards are drawn from the deck.\nHearts (♥): Potions that restore 2–10 health (max 20). One use per room; extras discarded.\nDiamonds (♦): Weapons you can equip (2–10) to fight monsters.\nClubs (♣) & Spades (♠): Monsters\nFighting barehanded, take full damage.\nFighting with a weapon - Weapons start out with their Diamond value, but upon killing a monster with lower HP than your weapon value your weapon becomes the monster's hp value. \n     Example: Using an 8♦ to kill a 6♣ changes your weapon attack power to 6.\nFlee: Skip a room before any actions to return its cards to the bottom of the deck. You may not flee 2 consecutive rooms.\n");
		}



	System.out.println("Good Luck, Scoundrel.");
	ui.start();
}
}