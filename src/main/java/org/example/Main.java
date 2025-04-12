package org.example;

import org.example.entities.Deck;

public class Main {
public static void main(String[] args) {
	Deck deck = new Deck();

	deck.shuffle();

	System.out.println("\nDealing cards:");
	for (int i = 0; i < 10; i++) {
		System.out.println(deck.dealCard());
	}

	System.out.println("\nRemaining cards in the deck:");
	deck.displayDeck();

	System.out.println("\nNumber of cards left: " + deck.cardsLeft());
	System.out.println("\nScore: " + deck.score());
}
}