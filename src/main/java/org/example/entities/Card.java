package org.example.entities;

import org.example.enums.CardColor;
import org.example.enums.EventRank;
import org.example.enums.Rank;
import org.example.enums.Suit;

public class Card {
private final Suit suit;
private final Rank rank;
private final EventRank eventRank;

public Card(Suit suit, Rank rank) {
	this.suit = suit;
	this.rank = rank;
	this.eventRank = null;
}

public Card(Suit suit, EventRank eventRank) {
	this.suit = suit;
	this.rank = null;
	this.eventRank = eventRank;
}

public Suit getSuit() {
	return suit;
}

public Rank getRank() {
	return rank;
}

public EventRank getEventRank() {
	return eventRank;
}

public boolean isEventCard() {
	return eventRank != null;
}

public int getValue() {
	if (rank != null) {
		return switch (rank) {
			case ACE -> 15;
			case TWO -> 2;
			case THREE -> 3;
			case FOUR -> 4;
			case FIVE -> 5;
			case SIX -> 6;
			case SEVEN -> 7;
			case EIGHT -> 8;
			case NINE -> 9;
			case TEN -> 10;
			case PAGE -> 11;
			case KNIGHT -> 12;
			case QUEEN -> 13;
			case KING -> 14;
		};
	} else if (eventRank != null) {
		// Event cards have value equal to their ordinal + 1
		return eventRank.ordinal() + 1;
	}
	return -1;
}


@Override
public String toString() {
	return getFaceString() + " " + getSuitSymbol();
}

private String getFaceString() {
	if (rank != null) {
		return switch (rank) {
			case ACE -> "A";
			case TWO -> "2";
			case THREE -> "3";
			case FOUR -> "4";
			case FIVE -> "5";
			case SIX -> "6";
			case SEVEN -> "7";
			case EIGHT -> "8";
			case NINE -> "9";
			case TEN -> "10";
			case PAGE -> "P";
			case KNIGHT -> "Kn";
			case QUEEN -> "Q";
			case KING -> "K";
		};
	} else if (eventRank != null) {
		return switch (eventRank) {
			case ONE -> "Fl";
			case TWO -> "Mgn";
			case THREE -> "HP";
			case FOUR -> "Ems";
			case FIVE -> "Emr";
			case SIX -> "Hpt";
			case SEVEN -> "L";
			case EIGHT -> "Ch";
			case NINE -> "Str";
			case TEN -> "Hrt";
			case ELEVEN -> "WoF";
			case TWELVE -> "Jst";
			case THIRTEEN -> "HM";
			case FOURTEEN -> "Dth";
			case FIFTEEN -> "Te";
			case SIXTEEN -> "Dvl";
			case SEVENTEEN -> "Twr";
			case EIGHTEEN -> "Sr";
			case NINETEEN -> "Mn";
			case TWENTY -> "Sun";
			case TWENTY_ONE -> "Jmt";
			case TWENTY_TWO -> "Wld";
		};
	}
	return "";
}

private String getSuitSymbol() {
	return switch (suit) {
		case CUPS -> "C";//"\uD800\uDCEF"; // Cup
		case SWORDS -> "S";//"⚸";
		case PENTACLES -> "P"; //"⛧";
		case WANDS -> "W";//"⸝*";
		case EVENT -> "E";//"\uD83D\uDD2E"; // Crystal Ball
	};
}
public CardColor getColor() {
	return suit.getColor();
}

public boolean isMonster() {
	return suit == Suit.WANDS || suit == Suit.PENTACLES;
}

public boolean isHealing() {
	return suit == Suit.CUPS;
}

public boolean isWeapon() {
	return suit == Suit.SWORDS;
}
}