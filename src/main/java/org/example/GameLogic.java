package org.example;

import org.example.entities.Card;
import org.example.entities.Deck;
import org.example.entities.Player;
import org.example.enums.Suit;

import java.util.Iterator;
import java.util.List;

public class GameLogic {
private final Deck deck;
private final Player player;
private final UI ui;
private int EnemyHealth;
private String EnemyName;
private boolean weaponFresh = false;

public GameLogic(Deck deck, Player player, UI ui) {
	this.deck = deck;
	this.player = player;
	this.ui = ui;
	EnemyHealth = 0;
	EnemyName = "";
}

public void handleCardInteraction(Card card) {
	Suit suit = card.getSuit();
	switch (suit) {
		case CUPS -> handleHeartCard(card);
		case WANDS, PENTACLES -> handleMonsterCard(card);
		case SWORDS -> handleDiamondCard(card);
	}
}

private void handleHeartCard(Card card) {
	if (!player.hasHealed()) {
		int healAmount = card.getValue();
		int newHealth = Math.min(player.getCurrentHealth() + healAmount, player.getMaxHealth());
		player.setCurrentHealth(newHealth);
		player.setHasHealed(true);
		ui.getPlayfield().remove(card);
		System.out.println("You have healed yourself. Current health: " + player.getCurrentHealth());
	} else {
		System.out.println("You have already healed yourself in this room. The potion turns to dust");
		ui.getPlayfield().remove(card);
	}
}

private void handleMonsterCard(Card card) {
	EnemyName = card.toString();
	System.out.println("You approach " + EnemyName + ".");
	EnemyHealth = card.getValue();
	int choice = ui.getAttackChoice();

	if (choice == 1) {
		attackBareHanded(card);
	} else {
		attackWithWeapon(card);
	}
}

private void attackBareHanded(Card card) {
	System.out.println("You attack the enemy with your bare hands.");
	player.setAttackPower(EnemyHealth);
	int damage = player.getCurrentHealth() - card.getValue();
	player.setCurrentHealth(damage);
	if (player.getCurrentHealth() <= 0) {
		System.out.println("You have been defeated.");
		System.out.println("Your final score is: " + getScore());
		System.exit(0);
	} else {
		System.out.println("You slay the monster but take " + EnemyHealth + " damage.");
		System.out.println("You have " + player.getCurrentHealth() + " health left.");
	}
	ui.getPlayfield().remove(card);
}

private void attackWithWeapon(Card card) {
	if (!weaponFresh && EnemyHealth >= player.getWeaponPower()) {
		System.out.println("Your weapon is already bound to slay weaker foes. You must fight barehanded.");
		attackBareHanded(card);
	} else {
		System.out.println("You attack the enemy with a weapon.");
		if (player.getWeaponPower() > EnemyHealth) {
			System.out.println("You have defeated the enemy, and your weapon is now weaker. Attack Power is now: " + card.getValue());
			weaponFresh = false;
			player.setWeaponPower(EnemyHealth);
			ui.getPlayfield().remove(card);
		} else if (player.getWeaponPower() == EnemyHealth) {
			System.out.println("You have defeated the enemy.");
			weaponFresh = false;
			ui.getPlayfield().remove(card);
		} else if (player.getWeaponPower() < EnemyHealth) {
			weaponFresh = false;
			int damage = card.getValue() - player.getWeaponPower();
			player.setCurrentHealth(player.getCurrentHealth() - damage);
			if (player.getCurrentHealth() <= 0) {
				System.out.println("You have been defeated.");
				System.out.println("Your final score is: " + getScore());
				System.exit(0);
			} else {
				int some = player.getWeaponPower() - card.getValue();
				System.out.println("You have defeated the enemy, but you took " + some + " damage.");
				System.out.println("You have " + player.getCurrentHealth() + " health left.");
			}
			ui.getPlayfield().remove(card);
		}
	}
}

public void discard(List<Card> cards) {
	Iterator<Card> iterator = cards.iterator();
	while (iterator.hasNext()) {
		Card card = iterator.next();
		deck.addToFront(card);
		iterator.remove();
	}
}

public void flee() {
	System.out.println("You have fled the room.");
	player.setHasFled(true);
	discard(ui.getPlayfield());
	ui.fillRoom();
	ui.nextRoom();
}

private void handleDiamondCard(Card card) {
	player.setWeaponPower(card.getValue());
	ui.getPlayfield().remove(card);
	weaponFresh = true;
	System.out.println("You have found a weapon! Your attack power is now: " + player.getWeaponPower());
}

private int getScore() {
	return deck.score() + player.getCurrentHealth() + player.getWeaponPower();
}
}