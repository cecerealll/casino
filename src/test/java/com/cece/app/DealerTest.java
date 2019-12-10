package com.cece.app;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import com.cece.app.Card.Rank;
import com.cece.app.Card.Suit;

import org.junit.Test;

/**
 * DealerTest
 */
public class DealerTest extends PlayerTest<Dealer> {

    protected void resetTest() {
        player = new Dealer();
    }

    @Test
    public void testShouldHit() {
        Hand hand = player.getHand();
        Card card = new Card(Rank.ACE, Suit.CLUB).flip();

        hand.addCard(card);
        hand.addCard(card);

        for (int i = 2; i <= 31; i++) {
            assertEquals(i, hand.evaluate());

            if (i <= 16) {
                assertTrue(player.shouldHit());
            } else {
                assertFalse(player.shouldHit());
            }

            hand.addCard(card);
        }
    }
}