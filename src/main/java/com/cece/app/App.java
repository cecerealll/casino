package com.cece.app;

/**
 *
 */
public class App {
    public static void main(String[] args) {
        Blackjack game = Blackjack.init();
        boolean isActive = true;

        while (isActive) {
            try {
                game.playRound();
            } catch (OutOfPlayersException e) {
                System.out.println(e.getMessage());
                isActive = false;
            }
        }
    }
}
