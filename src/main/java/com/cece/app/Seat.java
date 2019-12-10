package com.cece.app;

/**
 * Seat
 */
public class Seat extends Player {

    // hand value at which players should hit if they fall under
    private static final int[] HIT_THRESHOLDS = { 16, 12, 12, 11, 11, 11, 16, 16, 16, 16 };
    private static final int DEFAULT_CHIPS = 100;
    private int chips;
    private int bettingBox;

    public Seat() {
        super();
        chips = DEFAULT_CHIPS;
    }

    public int getChips() {
        return chips;
    }

    public int bettingBox() {
        return bettingBox;
    }

    public void wager(int chips) throws InsufficientChipsException {
        if (chips > this.chips) {
            throw new InsufficientChipsException();
        }

        this.chips -= chips;
        this.bettingBox += chips;
    }

    public void collectWinnings() {
        this.chips += this.bettingBox * 2;
        this.bettingBox = 0;
    }

    public void loseWager() {
        this.bettingBox = 0;
    }

    public boolean shouldHit(Hand dealerHand) {
        return HIT_THRESHOLDS[dealerHand.evaluate() - 1] >= hand.evaluate();
    }

    @Override
    public String toString() {
        return "Chips: " + chips + "\nWagered: " + bettingBox + "\n" + super.toString();
    }

}