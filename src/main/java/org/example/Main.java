package org.example;
import java.util.Scanner;

public class Main {
public static void main(String[] args){
Scanner scanner = new Scanner(System.in);
	UI ui = new UI();
	int choice;
	System.out.println("Welcome, Hea\uD801\uDD63hen. Would you like to Read the rules, or Begin?");
	System.out.println("1. Read the rules");
	System.out.println("2. Begin");
	System.out.print("> ");
	choice = scanner.nextInt();
	scanner.nextLine();
	while (choice != 1 && choice != 2) {
		System.out.println("Invalid Option. Please try again.\n");
		System.out.println("1. Read the rules");
		System.out.println("2. Begin");
		System.out.print("> ");
		choice = scanner.nextInt();
		scanner.nextLine();
	}
	if (choice == 1) {
		System.out.println();
		System.out.println("Welcome to Heathen, a card game where you play as a scoundrel trying to escape a dungeon. You will face monsters and collect weapons and potions to survive.\nThis game was created by Zach Gage and Kurt Bieg.\n");

		System.out.println("Goal: Clear the deck. You lose if your health hits 0.\nRooms: Each room is between 1 and 6 cards. Choose them in any order. Once one card is left the room is clear, and new cards are drawn from the deck.\nHearts (♥): Potions that restore 2–10 health (max 20). One use per room; extras discarded.\nDiamonds (♦): Weapons you can equip (2–10) to fight monsters.\nClubs (♣) & Spades (♠): Monsters\nFighting barehanded, take full damage.\nFighting with a weapon - Weapons start out with their Diamond value, but upon killing a monster with lower HP than your weapon value your weapon becomes the monster's hp value. \n     Example: Using an 8♦ to kill a 6♣ changes your weapon attack power to 6.\nFlee: Skip a room before any actions to return its cards to the bottom of the deck. You may not flee 2 consecutive rooms.\n");
		}
	if (choice == 2) {
		System.out.println("Do you want to play with the (1) Original weapon rules or the (2)New rules?\n");
		System.out.print("> ");
		choice = scanner.nextInt();
		scanner.nextLine();
		if (choice == 2) {
			System.out.println("You have chosen the New rules. You will be able to attack enemies with a used weapon");
			 GameLogic.setAllowUsedWeaponOverHit();
		} else if (choice == 1) {
			ui.start();
		} else {
			System.out.println("Invalid Option. Please try again.\n");
			System.out.print("> ");
			choice = scanner.nextInt();
			scanner.nextLine();
		}
	}
	//choose combat options
	ui.start();
}
}