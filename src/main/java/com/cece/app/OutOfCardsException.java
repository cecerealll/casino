package com.cece.app;

/**
 * OutOfCardsException
 */
public class OutOfCardsException extends Exception {

    public OutOfCardsException() {
        super("Deck is out of cards");
    }

}