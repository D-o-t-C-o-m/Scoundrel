package org.example.entities;

import org.example.enums.Suit;
import org.example.enums.Rank;

public class Card {
private final Suit suit;
private final Rank rank;

public Card(Suit suit, Rank rank) {
	this.suit = suit;
	this.rank = rank;
}

public Suit getSuit() {
	return suit;
}

public Rank getRank() {
	return rank;
}

public int getValue() {
	return switch (rank) {
		case ACE -> 14;
		case TWO -> 2;
		case THREE -> 3;
		case FOUR -> 4;
		case FIVE -> 5;
		case SIX -> 6;
		case SEVEN -> 7;
		case EIGHT -> 8;
		case NINE -> 9;
		case TEN -> 10;
		case JACK -> 11;
		case QUEEN -> 12;
		case KING -> 13;
		default -> throw new IllegalArgumentException("Invalid card rank: " + rank);
	};
}

@Override
public String toString() {
	String face = "";
	String icon = "";
	if (rank == Rank.ACE) {
		face = "A";
	}
	if (rank == Rank.TWO) {
		face = "2";
	}
	if (rank == Rank.THREE) {
		face = "3";
	}
	if (rank == Rank.FOUR) {
		face = "4";
	}
	if (rank == Rank.FIVE) {
		face = "5";
	}
	if (rank == Rank.SIX) {
		face = "6";
	}
	if (rank == Rank.SEVEN) {
		face = "7";
	}
	if (rank == Rank.EIGHT) {
		face = "8";
	}
	if (rank == Rank.NINE) {
		face = "9";
	}
	if (rank == Rank.TEN) {
		face = "10";
	}
	if (rank == Rank.JACK) {
		face = "J";
	}
	if (rank == Rank.QUEEN) {
		face = "Q";
	}
	if (rank == Rank.KING) {
		face = "K";
	}
	if (suit == Suit.HEARTS) {
		icon += "♥";
	}
	if (suit == Suit.DIAMONDS) {
		icon += "♦";
	}
	if (suit == Suit.CLUBS) {
		icon += "♣";
	}
	if (suit == Suit.SPADES) {
		icon += "♠";
	}
	return face +" "+ icon;
}
}
