package org.example.entities;

import org.example.enums.EventRank;
import org.example.enums.Suit;
import org.example.enums.Rank;

public class Card {
private final Suit suit;
private Rank rank;
private EventRank eventRank;

public Card(Suit suit, Rank rank) {
	this.suit = suit;
	this.rank = rank;

}

public Card(Suit suit, EventRank eventRank) {
	this.suit = suit;
	this.eventRank = eventRank;
}

public Suit getSuit() {
	return suit;
}

public Rank getRank() {
	return rank;
}

//
@Override
public String toString() {
	String face = "";
	String icon = "";
	if (rank == org.example.enums.Rank.ACE) {
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
	if (rank == Rank.PAGE) {
		face = "P";
	}
	if (rank == Rank.KNIGHT) {
		face = "Kn";
	}
	if (rank == Rank.QUEEN) {
		face = "Q";
	}
	if (rank == Rank.KING) {
		face = "K";
	}
	if (eventRank == EventRank.ONE) {
		face = "Fl";
	}
	if (eventRank == EventRank.TWO) {
		face = "Mgn";
	}
	if (eventRank == EventRank.THREE) {
		face = "HP";
	}
	if (eventRank == EventRank.FOUR) {
		face = "Ems";
	}
	if (eventRank == EventRank.FIVE) {
		face = "Emr";
	}
	if (eventRank == EventRank.SIX) {
		face = "Hpt";
	}
	if (eventRank == EventRank.SEVEN) {
		face = "L";
	}
	if (eventRank == EventRank.EIGHT) {
		face = "Ch";
	}
	if (eventRank == EventRank.NINE) {
		face = "Str";
	}
	if (eventRank == EventRank.TEN) {
		face = "Hrt";
	}
	if (eventRank == EventRank.ELEVEN) {
		face = "WoF";
	}
	if (eventRank == EventRank.TWELVE) {
		face = "Jst";
	}
	if (eventRank == EventRank.THIRTEEN) {
		face = "HM";
	}
	if (eventRank == EventRank.FOURTEEN) {
		face = "Dth";
	}
	if (eventRank == EventRank.FIFTEEN) {
		face = "Te";
	}
	if (eventRank == EventRank.SIXTEEN) {
		face = "Dvl";
	}
	if (eventRank == EventRank.SEVENTEEN) {
		face = "Twr";
	}
	if (eventRank == EventRank.EIGHTEEN) {
		face = "Sr";
	}
	if (eventRank == EventRank.NINETEEN) {
		face = "Mn";
	}
	if (eventRank == EventRank.TWENTY) {
		face = "Sun";
	}
	if (eventRank == EventRank.TwentyOne) {
		face = "Jmt";
	}
	if (eventRank == EventRank.TwentyTwo) {
		face = "Wld";
	}
	if (suit == Suit.CUPS) {
		icon += "\uD800\uDCEF"; //Cup
		//icon += "❤️"; //Heart
		//icon += "HEART"; // Placeholder for Heart icon
	}
	if (suit == Suit.SWORDS) {
		//icon += "⚔️"; //Sword
		icon += "⚸";
		//icon += "DIAMOND"; // Placeholder for Diamond icon
	}
	if (suit == Suit.PENTACLES) {
		//icon += "\uD83D\uDC80"; //Skull
		icon += "⛧";
		//icon += "CLUB"; // Placeholder for Club icon
	}
	if (suit == Suit.WANDS) {
		//	icon += "\uD83E\uDDDF"; // Zombie
		icon += "⸝*";
		//icon += "SPADE"; // Placeholder for Spade icon
	}
	if (suit == Suit.EVENT) {
		icon += "\uD83D\uDD2E"; // Crystal Ball
		//icon += "⚪"; // Placeholder for Event icon
	}
	return face + " " + icon;
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
	} else if (rank == Rank.PAGE) {
		return 11;
	} else if (rank == Rank.KNIGHT) {
		return 12;
	} else if (rank == Rank.QUEEN) {
		return 13;
	} else if (rank == Rank.KING) {
		return 14;
		//For Event cards
	} else if (eventRank == EventRank.ONE) {
		return 1;
	} else if (eventRank == EventRank.TWO) {
		return 2;
	} else if (eventRank == EventRank.THREE) {
		return 3;
	} else if (eventRank == EventRank.FOUR) {
		return 4;
	} else if (eventRank == EventRank.FIVE) {
		return 5;
	} else if (eventRank == EventRank.SIX) {
		return 6;
	} else if (eventRank == EventRank.SEVEN) {
		return 7;
	} else if (eventRank == EventRank.EIGHT) {
		return 8;
	} else if (eventRank == EventRank.NINE) {
		return 9;
	} else if (eventRank == EventRank.TEN) {
		return 10;
	} else if (eventRank == EventRank.ELEVEN) {
		return 11;
	} else if (eventRank == EventRank.TWELVE) {
		return 12;
	} else if (eventRank == EventRank.THIRTEEN) {
		return 13;
	} else if (eventRank == EventRank.FOURTEEN) {
		return 14;
	} else if (eventRank == EventRank.FIFTEEN) {
		return 15;
	} else if (eventRank == EventRank.SIXTEEN) {
		return 16;
	} else if (eventRank == EventRank.SEVENTEEN) {
		return 17;
	} else if (eventRank == EventRank.EIGHTEEN) {
		return 18;
	} else if (eventRank == EventRank.NINETEEN) {
		return 19;
	} else if (eventRank == EventRank.TWENTY) {
		return 20;
	} else if (eventRank == EventRank.TwentyOne) {
		return 21;
	} else if (eventRank == EventRank.TwentyTwo) {
		return 22;
	} else {
		return -1; // Invalid rank
	}

}
}