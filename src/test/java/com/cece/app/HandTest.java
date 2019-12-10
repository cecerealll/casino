package com.cece.app;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import com.cece.app.Card.Rank;
import com.cece.app.Card.Suit;

import org.junit.Before;
import org.junit.Test;

public class HandTest {
    Hand hand;
    Card card = new Card(Rank.EIGHT, Suit.HEART);

    @Before
    public void initialize() {
        hand = new Hand();
    }

    @Test
    public void testSize() {
        assertEquals(0, hand.getCards().size());
        assertEquals(0, hand.size());

        hand.getCards().add(card);
        assertEquals(1, hand.getCards().size());
        assertEquals(1, hand.size());
    }

    @Test
    public void testAddCard() {
        hand.addCard(card);
        assertTrue("addCard should increments handsize by 1", hand.size() == 1);
        assertEquals(card, hand.getCards().get(0));
    }

    @Test
    public void testClear() {
        hand.addCard(card);
        hand.addCard(card);
        assertTrue("should have more than 0 cards in hand", hand.size() > 0);

        hand.clear();
        assertTrue("should clear all cards in hand", hand.size() == 0);
    }

    // TODO unsure bout this one too
    @Test
    public void testReveal() {
        hand.addCard(new Card(Rank.EIGHT, Suit.HEART).flip());
        hand.addCard(new Card(Rank.EIGHT, Suit.HEART));
        hand.addCard(new Card(Rank.EIGHT, Suit.HEART));

        System.out.println(card.isFaceUp());

        assertTrue("there should be one face up card in the hand", isFaceUpCounter(hand) == 1);

        hand.reveal();

        assertTrue("all the cards in the hand should be face up", isFaceUpCounter(hand) == hand.size());

    }

    // TODO is a helper necessary?
    public static long isFaceUpCounter(Hand hand) {
        return hand.getCards().stream().filter(Card::isFaceUp).count();
    }

    // TODO is there need to test for face down cases if it's covered in Card?
    @Test
    public void testEvaluateAllCardsFaceUp() {
        hand.addCard(new Card(Rank.EIGHT, Suit.HEART).flip());
        hand.addCard(new Card(Rank.EIGHT, Suit.HEART).flip());

        assertTrue("should evaluate to sum of revealed cards", hand.evaluate() == 16);
    }

    @Test
    public void testEvaluateAllCardsFaceDown() {
        hand.addCard(new Card(Rank.EIGHT, Suit.HEART));
        hand.addCard(new Card(Rank.EIGHT, Suit.HEART));

        assertTrue("should evaluate to sum of revealed cards", hand.evaluate() == 0);
    }

    @Test
    public void testEvaluateSomeCardsFaceDown() {
        hand.addCard(new Card(Rank.EIGHT, Suit.HEART).flip());
        hand.addCard(new Card(Rank.EIGHT, Suit.HEART));

        assertTrue("should evaluate to sum of revealed cards", hand.evaluate() == 8);
    }

    // TODO redundant?
    // @Test
    // public void getSize() {
    // }

    // @Test
    // public void getCards() {
    // }

}