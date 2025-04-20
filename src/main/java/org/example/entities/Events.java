package org.example.entities;

public class Events {

public void getEvent(int event) {

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
	private void theFool () {
		// Implementation pending
	}

	/**
	 * Can be used as a one time use scroll to Fireball an enemy for X Damage
	 * Consumable
	 */
	private void theMagician () {
		// Implementation pending
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

	/**
	 * Hold one healing item
	 */
	private void theLovers () {
		// Implementation pending
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


