package com.cece.app;

import static org.junit.Assert.*;

import com.cece.app.Card.Rank;
import com.cece.app.Card.Suit;

import org.junit.*;

public class CardTest {
    Card card;

    @Before
    public void initialize() {
        card = new Card(Rank.ACE, Suit.CLUB);

    }

    @Test
    public void testIsFaceUpIsFalse() {
        assertFalse("should be false by default", card.isFaceUp());

    }

    @Test
    public void testFlip() {
        card.flip();

        assertTrue("should be true after flipping", card.isFaceUp());

        card.flip();

        assertFalse("should be false after flipping again", card.isFaceUp());
    }

    @Test
    public void testEvaluateIsFaceUpFalse() {
        assertTrue("should be 0 if face down", card.evaluate() == 0);
    }

    @Test
    public void testEvaluateIsFaceUpTrue() {
        card.flip();
        assertTrue("should return rank value if face up", card.evaluate() == 1);
    }

    @Test
    public void testToString() {
        assertEquals("face down card", card.toString());

        card.flip();
        assertEquals("ace of clubs", card.toString());
    }

    @Test
    public void testEquals() {
        Card newCard = new Card(Rank.ACE, Suit.CLUB);

        assertEquals(card, newCard);

    }

    @Test
    public void testNotEquals() {
        Card cardWithDiffRank = new Card(Rank.TWO, Suit.CLUB);
        Card cardWithDiffSuit = new Card(Rank.ACE, Suit.HEART);
        Card cardWithDiffSuitAndRank = new Card(Rank.FOUR, Suit.SPADE);

        assertNotEquals(card, cardWithDiffRank);
        assertNotEquals(card, cardWithDiffSuit);
        assertNotEquals(card, cardWithDiffSuitAndRank);
    }
}
