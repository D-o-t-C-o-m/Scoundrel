package org.example.entities;

import org.example.enums.Rank;
import org.example.enums.Suit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
private final List<Card> cards;
private final List<Card> discards;

public Deck() {
	cards = new ArrayList<>();
	discards = new ArrayList<>();
	for (Suit suit : Suit.values()) {
		for (Rank rank : Rank.values()) {
			cards.add(new Card(suit, rank));
		}
	}
	redFaceRemover();
}

public void shuffle() {
	Collections.shuffle(cards);

}

public Card dealCard() {
	if (cards.isEmpty()) {
		System.out.println("Deck is empty. No more cards to deal.");
		return null;
	}

	discards.add(cards.getLast());
	return cards.removeLast();
}

public int cardsLeft() {
	return cards.size();
}

public void displayDeck() {
	for (Card card : cards) {
		System.out.println(card);
	}
}

public void redFaceRemover() {
	cards.removeIf(card -> (card.getSuit().equals(Suit.CUPS) || card.getSuit().equals(Suit.SWORDS)) &&
			(card.getRank().equals(Rank.PAGE) || card.getRank().equals(Rank.KING) ||
					card.getRank().equals(Rank.QUEEN) || card.getRank().equals(Rank.KNIGHT)));
}

public int score() {
	int score = 0;
	for (Card card : discards) {
		if (card.getSuit().equals(Suit.PENTACLES) || card.getSuit().equals(Suit.WANDS)) {
			score += card.getValue();
		}

	}
	return score;
}

public void add(Card card) {
	if (card != null) {
		cards.add(card);
		discards.remove(card);
	} else {
		System.out.println("Card cannot be null.");
	}
}

public boolean isEmpty() {
	return cards.isEmpty();

}

public void addToFront(Card card) {
	cards.add(0, card);
	discards.remove(card);
}

public void getDiscards() {
	for (Card card : discards) {
		System.out.println(card);
	}
}
}
