package com.cece.app;

/**
 * OutOfPlayersException
 */
public class OutOfPlayersException extends Exception {
    public OutOfPlayersException() {
        super("All players have left the table");
    }
}
