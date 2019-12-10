package com.cece.app;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class DeckTest {
    Deck deck;

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Before
    public void initialize() {
        deck = Deck.init();
    }

    @Test
    public void testDeckIsNotEmpty() {
        assertTrue("should contain 52 cards after initalizing", deck.getDeckSize() == 52);
    }

    @Test
    public void testShuffle() {
        Deck anotherDeck = Deck.init();
        anotherDeck.shuffle();

        assertNotEquals(deck, anotherDeck);
    }

    @Test
    public void testShuffleIsUnique() {
        Deck anotherDeck = Deck.init();

        anotherDeck.shuffle();
        deck.shuffle();

        assertNotEquals(deck, anotherDeck);
    }

    @Test
    public void testDrawWithNonEmptyDeck() throws OutOfCardsException {
        deck.draw();

        assertTrue("contains 52 cards", deck.getDeckSize() == 51);
    }

    @Test
    public void testDrawWithEmptyDeck() throws OutOfCardsException {
        for (int i = 0; i < 52; i++) {
            deck.draw();
        }
        assertTrue("deck should be empty", deck.getDeckSize() == 0);
        thrown.expect(OutOfCardsException.class);
        deck.draw();

    }
}