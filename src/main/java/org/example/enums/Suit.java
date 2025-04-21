package org.example.enums;


public enum Suit {
	CUPS(CardColor.RED),
	SWORDS(CardColor.RED),
	WANDS(CardColor.BLACK),
	PENTACLES(CardColor.BLACK),
	EVENT(CardColor.NONE);

private final CardColor color;

Suit(CardColor color) {
	this.color = color;
}

public CardColor getColor() {
	return color;
}
}
