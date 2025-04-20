package org.example.entities;

public class events {

public void getEvent(String event) {
	//should this be an int?
	switch (event) {
		case "fool" -> theFool();
		case "magician" -> theMagician();
		case "highPriestess" -> theHighPriestess();
		case "empress" -> theEmpress();
		case "emperor" -> theEmperor();
		case "hierophant" -> theHierophant();
		case "lovers" -> theLovers();
		case "chariot" -> theChariot();
		case "strength" -> theStrength();
		case "hermit" -> theHermit();
		case "wheelOfFortune" -> theWheelOfFortune();
		case "justice" -> Justice();
		case "hangedMan" -> theHangedMan();
		case "death" -> Death();
		case "temperance" -> theTemperance();
		case "judgement" -> theJudgement();
		case "world" -> theWorld();
		case "devil" -> theDevil();
		case "tower" -> theTower();
		case "star" -> theStar();
		case "moon" -> theMoon();
		case "sun" -> theSun();
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


