package org.example;

public class Main {
public static void main(String[] args) {
	UI ui = new UI();
	System.out.println("Welcome, Scoundrel.");
	System.out.println("There are many rooms in this dungeon, and you must fight your way to the exit.");
	System.out.println("You will be given a choice to enter a room or flee, but you cannot flee twice in a row.");
	System.out.println("After entering a room, you may see different suits. ♥ will heal you, but can only be used once per room. ♦ are weapons, they will degrade after kills. ♣ & ♠ are enemies.");
	System.out.println("If you choose to attack without a weapon, you will take the full damage of the enemy.");
	System.out.println("Good Luck, Scoundrel.");
	ui.start();
}
}