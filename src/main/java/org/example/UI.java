package org.example;

import org.example.entities.Card;
import org.example.entities.Deck;
import org.example.entities.Player;


public class UI {
private final Player player;
private final Deck deck;
private final RoomManager roomManager;
private final InputHandler inputHandler;
private final CombatSystem combatSystem;
private final WeaponSystem weaponSystem;

public UI() {
	deck = new Deck();
	player = new Player(Constants.DEFAULT_MAX_HEALTH, Constants.DEFAULT_WEAPON_POWER);

	inputHandler = new InputHandler();
	weaponSystem = new WeaponSystem(player);
	combatSystem = new CombatSystem(player, weaponSystem, inputHandler);
	roomManager = new RoomManager(deck);
}

public void start() {
	deck.shuffle();
	roomManager.setupFirstRoom();
	gameLoop();
}

private void gameLoop() {
	while (true) {
		displayGameState();

		int choice = inputHandler.getRoomEntryChoice();

		if (choice == 1) {
			System.out.println("You step forth");
			player.setHasFled(false);
			processRoom();
		} else {
			handleFleeAttempt();
		}
	}
}

private void displayGameState() {
	System.out.println("\nHealth Points: " + player.getCurrentHealth() + "/ " + player.getMaxHealth() +
			" | Attack Power: " + player.getWeaponPower() + " | " +
			"Remaining Obstacles: " + deck.cardsLeft());
	System.out.println("------------------------------------------------------------------");
	System.out.println(" " + roomManager.getPlayfield() + "\n");
}

private void handleFleeAttempt() {
	if (player.hasFled()) {
		System.out.println("You cannot flee again, you must go forward.");
		displayGameState();
		processRoom();
	} else {
		System.out.println("You have fled the room.");
		player.setHasFled(true);
		roomManager.discardCards(roomManager.getPlayfield());
		roomManager.resetRoomState();
	}
}

private void processRoom() {
	while (!roomManager.isRoomCleared() && !roomManager.isInFinalRoom()) {
		displayGameState();
		int cardIndex = inputHandler.getCardChoice(roomManager.getPlayfield().size()) - 1;

		Card selectedCard = roomManager.getPlayfield().get(cardIndex);
		processCardInteraction(selectedCard, cardIndex);

	}

	if (roomManager.isInFinalRoom()) {
		while (!roomManager.getPlayfield().isEmpty()) {
			displayGameState();
			int cardIndex = inputHandler.getCardChoice(roomManager.getPlayfield().size()) - 1;

			Card selectedCard = roomManager.getPlayfield().get(cardIndex);
			processCardInteraction(selectedCard, cardIndex);
		}
		checkWin();
	} else {
		System.out.println("Room cleared, you can now leave.\n");
		resetForNextRoom();
	}
}



private void processCardInteraction(Card card, int cardIndex) {
	if (card.isHealing()) {
		combatSystem.handleHealing(card.getValue());
		roomManager.removeCardAtIndex(cardIndex);
	} else if (card.isWeapon()) {
		weaponSystem.equipWeapon(card.getValue());
		roomManager.removeCardAtIndex(cardIndex);
	} else if (card.isMonster()) {
		boolean survived = combatSystem.handleCombat(card);
		if (survived) {
			roomManager.removeCardAtIndex(cardIndex);
		}
	}
}


private void resetForNextRoom() {
	player.setHasHealed(false);
	player.setHasFled(false);

	if (roomManager.hasBranchingPath()) {
		System.out.println("A branching path is before you.");
		int playfield1Size = roomManager.getPlayfield().size();
		int playfield2Size = roomManager.getPlayfield2().size();
		int roomChoice = inputHandler.getRoomChoice(playfield1Size, playfield2Size);
		roomManager.resolveRoomChoice(roomChoice);
	} else {
		roomManager.resetRoomState();
	}

}


private void checkWin() {
	System.out.println("You have cleared the final obstacle and escaped the dungeon!");
	System.out.println("You have " + player.getCurrentHealth() + " health left.");
	System.out.println("You have " + player.getWeaponPower() + " attack power left.");
	int score = calculateFinalScore();
	System.out.println("Your final score is: " + score);
	System.exit(0);
}

public int calculateFinalScore() {
	return deck.score() + player.getCurrentHealth() + player.getWeaponPower() + roomManager.getRoomCount();
}
}