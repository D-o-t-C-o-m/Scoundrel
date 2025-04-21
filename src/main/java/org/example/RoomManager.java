package org.example;

import org.example.entities.Card;
import org.example.entities.Deck;
import org.example.enums.CardColor;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RoomManager {
    private final Deck deck;
    private final List<Card> playfield;
    private final List<Card> playfield2;
    private final Random random;
    private boolean goodStart = false;
    private boolean winState = false;
    private int roomCount = 0;
    private Card lastRoomCard = null;


public RoomManager(Deck deck) {
        this.deck = deck;
        this.playfield = new ArrayList<>();
        this.playfield2 = new ArrayList<>();
        this.random = new Random();
    }

    public boolean isMonochromaticRoom(List<Card> cards) {
        if (cards.isEmpty()) {
            return false;
        }
        CardColor roomColor = cards.get(0).getColor();

        return cards.stream().allMatch(card -> card.getColor() == roomColor);
    }


    public void setupFirstRoom() {
        while (!goodStart) {
            playfield.clear();
            int size = Constants.DEFAULT_ROOM_SIZE;
            fillPlayfield(playfield, size);
            if (isMonochromaticRoom(playfield)) {
                discardCards(playfield);
                deck.shuffle();
            } else {
                goodStart = true;
                roomCount++;
            }
        }
    }

    private void fillPlayfield(List<Card> field, int size) {
        while (field.size() < size) {
            if (deck.isEmpty()) {
                winState = true;
                System.out.println("You sense that this is the final room.");
                break;
            }
            field.add(deck.dealCard());
        }
    }

    public void discardCards(List<Card> cards) {
        List<Card> cardsCopy = new ArrayList<>(cards);
        for (Card card : cardsCopy) {
            deck.addToFront(card);
        }
        cards.clear();
    }

    public void generateNewRoom() {
        int size = Constants.DEFAULT_ROOM_SIZE;
        int randomSizeRoll = rollDice();

        if (randomSizeRoll == 1) {
            System.out.println("The next room feels different than the others");
            size = rollDice() + 1;
            if (size == 7) {
                size = 6;
            }
        }
        fillPlayfield(playfield, size);
        int splitRoll = rollDice();
        if (splitRoll == 1) {
            int size2 = rollDice();
            if (size2 == 1) {
                size2 += 1;
            }
            fillPlayfield(playfield2, size2);
        }
    }

    private int rollDice() {
        return random.nextInt(Constants.DICE_MIN, Constants.DICE_MAX + 1);
    }

public void resolveRoomChoice(int choice) {
    
    saveLastCard();
    
    if (choice == 1) {

        discardCards(playfield2);
        playfield2.clear();


        //List<Card> cardsToKeep = new ArrayList<>(playfield);
        playfield.clear();

        fillPlayfield(playfield, Constants.DEFAULT_ROOM_SIZE - (lastRoomCard != null ? 1 : 0));

        if (lastRoomCard != null) {
            playfield.add(0, lastRoomCard);
            lastRoomCard = null;
        }
        } else if (choice == 2) {

            List<Card> temp = new ArrayList<>(playfield);
            playfield.clear();
            playfield.addAll(playfield2);
            playfield2.clear();

            if (lastRoomCard != null) {
                playfield.add(0, lastRoomCard);
                lastRoomCard = null;
            }

            discardCards(temp);
        }
    }




    public void removeCardAtIndex(int index) {
        if (index >= 0 && index < playfield.size()) {
            playfield.remove(index);
        }
    }

    public boolean hasBranchingPath() {
        return !playfield2.isEmpty();
    }

    public boolean isRoomCleared() {
        return playfield.size() <= 1;
    }

    public boolean isInFinalRoom() {
        return winState;
    }

public void resetRoomState() {
    Card lastCard = null;
    if (playfield.size() == 1) {
        lastCard = playfield.getFirst();
    }
    playfield.clear();
    playfield2.clear();

    generateNewRoom();

    if (lastCard != null) {
        playfield.add(0, lastCard);
    }
    roomCount++;
}

public List<Card> getPlayfield() {
        return playfield;
    }
    public List<Card> getPlayfield2(){
        return playfield2;
    }
public int getRoomCount() {
    return roomCount;
}

public void saveLastCard() {
    if (playfield.size() == 1) {
        lastRoomCard = playfield.getFirst();
    }
}

public void resetLastCard() {
    lastRoomCard = null;
}

}