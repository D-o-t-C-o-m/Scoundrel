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
		icon += "❤\uFE0F";
	}
	if (suit == Suit.DIAMONDS) {
		icon += "\uD83D\uDDE1\uFE0F";
	}
	if (suit == Suit.CLUBS) {
		icon += "\uD83D\uDC80";
	}
	if (suit == Suit.SPADES) {
		icon += "\uD83E\uDDDF\u200D♂\uFE0F";
	}
	return face +" "+ icon;
}

public int getValue() {
	if (rank == Rank.ACE) {
		return 14;
	} else if (rank == Rank.TWO) {
		return 2;
	} else if (rank == Rank.THREE) {
		return 3;
	} else if (rank == Rank.FOUR) {
		return 4;
	} else if (rank == Rank.FIVE) {
		return 5;
	} else if (rank == Rank.SIX) {
		return 6;
	} else if (rank == Rank.SEVEN) {
		return 7;
	} else if (rank == Rank.EIGHT) {
		return 8;
	} else if (rank == Rank.NINE) {
		return 9;
	} else if (rank == Rank.TEN) {
		return 10;
	} else if (rank == Rank.JACK) {
		return 11;
	} else if (rank == Rank.QUEEN) {
		return 12;
	} else if (rank == Rank.KING) {
		return 13;
	}
	return -1; // Invalid rank
}
}
