package com.cece.app;

/**
 * Card
 */
public class Card {
    private Rank rank = Rank.ACE;
    private Suit suit = Suit.SPADE;
    private boolean isFaceUp = false;

    public Card(Rank rank, Suit suit) {
        this.rank = rank;
        this.suit = suit;
    }

    public enum Suit {
        SPADE("spades"), HEART("hearts"), CLUB("clubs"), DIAMOND("diamonds"),;

        private String name;

        Suit(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

    }

    public enum Rank {
        ACE("ace", 1), TWO("two", 2), THREE("three", 3), FOUR("four", 4), FIVE("five", 5), SIX("six", 6),
        SEVEN("seven", 7), EIGHT("eight", 8), NINE("nine", 9), TEN("ten", 10), JACK("jack", 10), QUEEN("queen", 10),
        KING("king", 10);

        private String name;
        private int value;

        Rank(String name, int value) {
            this.name = name;
            this.value = value;
        }

        public String getName() {
            return name;
        }

        public int getValue() {
            return value;
        }

    }

    public int evaluate() {
        return isFaceUp ? rank.getValue() : 0;
    }

    public boolean isFaceUp() {
        return isFaceUp;
    }

    public Card flip() {
        isFaceUp = !isFaceUp;
        return this;
    }

    @Override
    public String toString() {
        return isFaceUp ? rank.getName() + " of " + suit.getName() : "face down card";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Card other = (Card) obj;
        if (rank != other.rank)
            return false;
        if (suit != other.suit)
            return false;
        return true;
    }

}