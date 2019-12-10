package com.cece.app;

/**
 * Dealer
 */
public class Dealer extends Player {

    private final static int HIT_THRESHOLD = 16;

    public boolean shouldHit() {
        return HIT_THRESHOLD >= hand.evaluate();
    }
}