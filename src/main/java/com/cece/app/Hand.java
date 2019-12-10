package com.cece.app;

import java.util.ArrayList;
import java.util.List;

/**
 * Hand
 */
public class Hand {

    private List<Card> cards = new ArrayList<>();

    public void addCard(Card card) {
        cards.add(card);
    }

    public void clear() {
        cards.clear();
    }

    public void reveal() {
        cards.stream().filter(c -> !c.isFaceUp()).forEach(Card::flip);
    }

    public int evaluate() {
        return cards.stream().map(Card::evaluate).reduce(0, (acc, curr) -> acc + curr);
    }

    public int size() {
        return cards.size();
    }

    public List<Card> getCards() {
        return cards;
    }

    @Override
    public String toString() {
        String s = "";
        for (Card c : cards) {
            s += "- " + c.toString() + "\n";
        }
        s += "Total is " + evaluate();

        return s;
    }

}