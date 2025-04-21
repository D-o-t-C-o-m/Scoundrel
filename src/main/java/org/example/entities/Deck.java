package org.example.entities;

import org.example.enums.Rank;
import org.example.enums.Suit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;


public class Deck {
private final List<Card> cards;
private final List<Card> discards;


public Deck() {
	cards = new ArrayList<>();
	discards = new ArrayList<>();
	initializeStandardCards();
	removeRedFaceCards();
	removeEventCards();
}


private void initializeStandardCards() {
	for (Suit suit : Suit.values()) {
		for (Rank rank : Rank.values()) {
			cards.add(new Card(suit, rank));
		}
	}
}


public void shuffle() {
	Collections.shuffle(cards);
}

public Card dealCard() {
	if (cards.isEmpty()) {
		System.out.println("Deck is empty. No more cards to deal.");
		return null;
	}
	Card dealtCard = cards.removeLast();
	discards.add(dealtCard);
	return dealtCard;
}

public int cardsLeft() {
	return cards.size();
}

public void displayDeck() {
	for (Card card : cards) {
		System.out.println(card);
	}
}

public void removeRedFaceCards() {
	cards.removeIf(card -> (card.getSuit().equals(Suit.CUPS) || card.getSuit().equals(Suit.SWORDS)) &&
			(card.getRank() != null && (card.getRank().equals(Rank.PAGE) || card.getRank().equals(Rank.KING) ||
					card.getRank().equals(Rank.QUEEN) || card.getRank().equals(Rank.KNIGHT))));
}

public void removeEventCards() {
	cards.removeIf(card -> card.getSuit().equals(Suit.EVENT));
}

public int score() {
	return discards.stream()
			.filter(card -> card.getSuit().equals(Suit.PENTACLES) || card.getSuit().equals(Suit.WANDS))
			.mapToInt(Card::getValue)
			.sum();
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
	//"front" is the bottom of the pile
	if (card != null) {
		cards.add(0, card);
		discards.remove(card);
	} else {
		System.out.println("Card cannot be null.");
	}
}


public List<Card> getDiscards() {
	return new ArrayList<>(discards);
}


public void displayDiscards() {
	for (Card card : discards) {
		System.out.println(card);
	}
}

public List<Card> getCardsBySuit(Suit suit) {
	return cards.stream()
			.filter(card -> card.getSuit() == suit)
			.collect(Collectors.toList());
}

public Card getStrongestMonster() {
	return cards.stream()
			.filter(Card::isMonster)
			.max((c1, c2) -> Integer.compare(c1.getValue(), c2.getValue()))
			.orElse(null);
}

public Card peekRandomCard() {
	if (cards.isEmpty()) {
		return null;
	}
	return cards.get((int)(Math.random() * cards.size()));
}
}