package org.example;

public class Main {
public static void main(String[] args) {
	InputHandler inputHandler = new InputHandler();
	int menuChoice = inputHandler.getMenuChoice();

	if (menuChoice == 1) {
		displayRules();
	}

	startGame(inputHandler);
}

private static void displayRules() {
	System.out.println();
	System.out.println("Welcome to Hea\uD801\uDD63hen, a card game where are trying to escape a dungeon.");
	System.out.println("The game follows in the footsteps of Scoundrel");
	System.out.println("I'll put the rest of this in later");
}

private static void startGame(InputHandler inputHandler) {
	int rulesChoice = inputHandler.getRulesChoice();

	if (rulesChoice == 2) {
		System.out.println("You have chosen the New rules. You will be able to attack enemies with a used weapon");
		WeaponSystem.setAllowUsedWeaponOverHit(true);
	}

	UI ui = new UI();
	ui.start();
}
}