package com.cece.app;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

/**
 * PlayerTest
 */
public abstract class PlayerTest<T extends Player> {

    protected T player;

    @Before
    public void initialize() {
        resetTest();
    }

    protected abstract void resetTest();

    @Test
    public void testNewPlayerHasEmptyHand() {
        Hand hand = player.getHand();
        assertNotNull(hand);
        assertEquals(0, hand.size());
    }

    @Test
    public void testToString() {
        assertEquals("Hand is:\nTotal is 0", player.toString());
    }
}