package com.cece.app;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Deck
 */
public class Deck {

    private List<Card> cards = new ArrayList<>();

    // private constructor, using init
    private Deck() {
    }

    public static Deck init() {
        Deck deck = new Deck();

        for (Card.Suit suit : Card.Suit.values()) {
            for (Card.Rank rank : Card.Rank.values()) {
                Card newCard = new Card(rank, suit);
                deck.cards.add(newCard);
            }
        }

        return deck;
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    public int getDeckSize() {
        return cards.size();
    }

    public Card draw() throws OutOfCardsException {
        int cardsSize = cards.size();

        if (cardsSize - 1 < 0) {
            throw new OutOfCardsException();
        }
        return cards.remove(cards.size() - 1);
    }

}