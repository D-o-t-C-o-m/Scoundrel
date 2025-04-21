package org.example.entities;

import org.example.InputHandler;

import java.util.Random;


public class Events {
private Player player;
private InputHandler inputHandler;


public Events(InputHandler inputHandler, Player player) {
	this.inputHandler = inputHandler;
	this.player = player;
}

public void getEvent() {
	Random random = new Random();
	int event = random.nextInt(22) + 1;
	switch (event) {
		case 1 -> theFool();
		case 2 -> theMagician();
		case 3 -> theHighPriestess();
		case 4 -> theEmpress();
		case 5 -> theEmperor();
		case 6 -> theHierophant();
		case 7 -> theLovers();
		case 8 -> theChariot();
		case 9 -> theStrength();
		case 10 -> theHermit();
		case 11 -> theWheelOfFortune();
		case 12 -> Justice();
		case 13 -> theHangedMan();
		case 14 -> Death();
		case 15 -> theTemperance();
		case 16 -> theJudgement();
		case 17 -> theWorld();
		case 18 -> theDevil();
		case 19 -> theTower();
		case 20 -> theStar();
		case 21 -> theMoon();
		case 22 -> theSun();
	}
}

/**
 * Gives you a healing item slot, but if you overheal you Overdose and lose max HP equal to the over heal.
 * IE 12 + 10 = 22, 22 - 2 = 20, - 2 Max HP is now 18
 */
private void theFool() {
	// Implementation pending
}

private void theMagician() {
	if (this.player.getInventory().isEmpty()) {
		System.out.println("A dusty scroll lays forgotten on a table, you have found a fireball scroll");
		this.player.addItemToInventory("Scroll");
	} else {
		boolean choice = inputHandler.getYesNoChoice("A scroll of fireball lays on the table, but you don't have anywhere to put it. do you want to take it and discard your current inventory?");
		if (choice) {
			this.player.removeItemFromInventory();
			this.player.addItemToInventory("Scroll");
		} else {
			System.out.println("You leave the scroll behind.");
		}
	}
}

	/**
	 * Can sell weapons for their Power as HP (IE A 5 of Swords can buy a 5 heal)
	 */
	private void theHighPriestess () {
		// Implementation pending
	}

	/**
	 * Can Sell HP for weapons power (IE 5 HP can buy a 5 weapon)
	 */
	private void theEmpress () {
		// Implementation pending
	}

	/**
	 * Restore 10 HP
	 */
	private void theEmperor () {
		// Implementation pending
	}

	/**
	 * Take half damage rounded up to from the next barehanded fight
	 */
	private void theHierophant () {
		// Implementation pending
	}

	private void theLovers () {
		if (this.player.getInventory().isEmpty()) {
			System.out.println("A corked health potion sits on a shelf");
			this.player.addItemToInventory("Potion");
		} else {
			boolean choice = inputHandler.getYesNoChoice("A corked health potion sits on a shelf, but you don't have anywhere to put it. do you want to take it and discard your current inventory?");
			if (choice) {
				this.player.removeItemFromInventory();
				this.player.addItemToInventory("Potion");
			} else {
				System.out.println("You leave the scroll behind.");
			}
		}
	}

	/**
	 * Replace One card in the room with the top card of the deck
	 */
	private void theChariot () {
		// Implementation pending
	}

	/**
	 * Reveals the deck
	 */
	private void theStrength () {
		// Implementation pending
	}

	/**
	 * Flee without Restriction
	 */
	private void theHermit () {
		// Implementation pending
	}

	/**
	 * Adds Crit and misses to weapons - Roll 1d6, 1 = Miss, 2-5 normal, 6 crit for 2x damage
	 */
	private void theWheelOfFortune () {
		// Implementation pending
	}

	/**
	 * Can hold a second weapon for you that can be used in combat
	 */
	private void Justice () {
		// Implementation pending
	}

	/**
	 * 1d20 damage - Cannot be fled from if you reroll the room he will remain
	 */
	private void theHangedMan () {
		// Implementation pending
	}

	/**
	 * An Ace with 1d6 additional Damage
	 */
	//Death: shuffle selected card and replace it with the strongest enemy left in the deck (usually ace).Useful to making the most of a fresh sword
	private void Death () {
		// Implementation pending
	}

	/**
	 * Reset your current weapon (discard all defeated cards)
	 */
	private void theTemperance () {
		// Implementation pending
	}

	/**
	 * Reroll all Red Cards in a room until they are black
	 */
	private void theJudgement () {
		// Implementation pending
	}

	/**
	 * Reroll all black cards in a room until they are red
	 */
	private void theWorld () {
		// Implementation pending
	}

	/**
	 * Two Weapon Slots, Maximum of 4 in offhand
	 */
	private void theDevil () {
		// Implementation pending
	}

	/**
	 * 25 max HP
	 */
	private void theTower () {
		// Implementation pending
	}

	/**
	 * Cannot Flee, but Can Reroll one card be room
	 */
	private void theStar () {
		// Implementation pending
	}

	/**
	 * Once per durability level can kill a monster without taking durability damage
	 */
	private void theMoon () {
		// Implementation pending
	}

	/**
	 * Deal +1 Damage and +1 Durability below 10hp
	 */
	private void theSun () {
		// Implementation pending
	}

}



