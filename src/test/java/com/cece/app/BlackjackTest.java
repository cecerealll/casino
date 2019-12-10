package com.cece.app;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * BlackjackTest
 */
public class BlackjackTest {
    Blackjack game;

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Before
    public void initialize() {
        game = Blackjack.init();
    }

    @Test
    public void testBlackjackHasShuffledDeckAndPlayers() {
        assertEquals(52, game.getDeck().getDeckSize());
        assertNotEquals(Deck.init(), game.getDeck());
        assertEquals(2, game.getSeats().size());
    }

    @Test
    public void testPlayRoundWithEmptySeats() {

    }

    // @Test
    // public void testToString() {

    // }

}