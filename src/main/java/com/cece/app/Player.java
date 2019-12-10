package com.cece.app;

/**
 * Player
 */
public abstract class Player {

    protected Hand hand;

    public Player() {
        hand = new Hand();
    }

    public Hand getHand() {
        return hand;
    }

    public String toString() {
        return "Hand is:\n" + hand.toString();
    }

}