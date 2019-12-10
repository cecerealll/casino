package com.cece.app;

import static org.junit.Assert.assertEquals;

import com.cece.app.Card.Rank;
import com.cece.app.Card.Suit;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * SeatTest
 */
public class SeatTest extends PlayerTest<Seat> {
    private static boolean[][] HIT_TABLE = { { true, true, true, true, true, true, true, true, true, true },
            { true, true, true, true, true, true, true, true, true, true },
            { true, true, true, true, true, true, true, true, true, true },
            { true, true, true, true, true, true, true, true, true, true },
            { true, true, true, true, true, true, true, true, true, true },
            { true, true, true, true, true, true, true, true, true, true },
            { true, true, true, true, true, true, true, true, true, true },
            { true, true, true, true, true, true, true, true, true, true },
            { true, true, true, true, true, true, true, true, true, true },
            { true, true, true, true, true, true, true, true, true, true },
            { true, true, true, false, false, false, true, true, true, true },
            { true, false, false, false, false, false, true, true, true, true },
            { true, false, false, false, false, false, true, true, true, true },
            { true, false, false, false, false, false, true, true, true, true },
            { true, false, false, false, false, false, true, true, true, true },
            { false, false, false, false, false, false, false, false, false, false },
            { false, false, false, false, false, false, false, false, false, false },
            { false, false, false, false, false, false, false, false, false, false },
            { false, false, false, false, false, false, false, false, false, false },
            { false, false, false, false, false, false, false, false, false, false } };

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    protected void resetTest() {
        player = new Seat();
    }

    @Test
    public void testConstructor() {
        assertEquals(100, player.getChips());
    }

    @Test
    public void testWagerThrowsNoException() throws InsufficientChipsException {
        player.wager(10);

        assertEquals(90, player.getChips());
        assertEquals(10, player.bettingBox());
    }

    @Test
    public void testWagerThrowsException() throws InsufficientChipsException {
        thrown.expect(InsufficientChipsException.class);
        player.wager(101);
    }

    @Test
    public void testCollectWinnings() throws InsufficientChipsException {
        assertEquals(100, player.getChips());

        player.wager(10);

        assertEquals(90, player.getChips());
        assertEquals(10, player.bettingBox());

        player.collectWinnings();

        assertEquals(110, player.getChips());
        assertEquals(0, player.bettingBox());
    }

    @Test
    public void testLoseWager() throws InsufficientChipsException {
        assertEquals(100, player.getChips());

        player.wager(10);

        assertEquals(90, player.getChips());
        assertEquals(10, player.bettingBox());

        player.loseWager();

        assertEquals(90, player.getChips());
        assertEquals(0, player.bettingBox());
    }

    @Test
    public void testShouldHit() {
        Hand hand = player.getHand();
        Hand dealersHand = new Hand();
        Card card = new Card(Rank.ACE, Suit.CLUB).flip();

        hand.addCard(card);
        hand.addCard(card);

        for (int handValue = 2; handValue <= 21; handValue++) {
            assertEquals(handValue, hand.evaluate());

            for (int dealersHandValue = 1; dealersHandValue <= 10; dealersHandValue++) {
                dealersHand.addCard(card);
                assertEquals(dealersHandValue, dealersHand.evaluate());
                assertEquals(HIT_TABLE[handValue - 2][dealersHandValue - 1], player.shouldHit(dealersHand));
            }
            dealersHand.clear();
            hand.addCard(card);
        }
    }

    @Test
    public void testToString() {
        assertEquals("Chips: 100\nWagered: 0\nHand is:\nTotal is 0", player.toString());
    }

}