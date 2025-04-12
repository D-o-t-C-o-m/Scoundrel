package org.example.entities;

import org.example.enums.Rank;
import org.example.enums.Suit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
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
	Iterator<Card> iterator = cards.iterator();
	while (iterator.hasNext()) {
		Card card = iterator.next();
		if ((card.getSuit().equals(Suit.HEARTS) || card.getSuit().equals(Suit.DIAMONDS)) &&
				(card.getRank().equals(Rank.ACE) || card.getRank().equals(Rank.KING) ||
						card.getRank().equals(Rank.QUEEN) || card.getRank().equals(Rank.JACK))) {
			iterator.remove();
		}
	}
}

public int score() {
	int score = 0;
	for (Card card : discards) {
		if (card.getSuit().equals(Suit.CLUBS) || card.getSuit().equals(Suit.SPADES)) {
			score += card.getValue();
		}

	}
	return score;
}
}
