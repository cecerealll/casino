package com.cece.app;

/**
 * InsufficientChipsException
 */
public class InsufficientChipsException extends Exception {

    public InsufficientChipsException() {
        super("Player is out of chips");
    }

}