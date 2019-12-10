package com.cece.app;

import java.util.ArrayList;
import java.util.List;

/**
 * Blackjack
 */
public class Blackjack {

    private static final int MINIMUM_WAGER = 10;
    private Deck deck;
    private List<Seat> seats = new ArrayList<>();
    private Dealer dealer = new Dealer();

    private Blackjack() {
    }

    public static Blackjack init() {
        Blackjack game = new Blackjack();
        game.deck = Deck.init();
        game.deck.shuffle();
        game.seats.add(new Seat());
        game.seats.add(new Seat());
        return game;
    }

    public Deck getDeck() {
        return deck;
    }

    public List<Seat> getSeats() {
        return seats;
    }

    public void playRound() throws OutOfPlayersException {
        Hand dealerHand = dealer.getHand();

        for (int i = 0; i < seats.size(); i++) {
            try {
                seats.get(i).wager(MINIMUM_WAGER);
            } catch (InsufficientChipsException e) {
                seats.remove(seats.get(i));
            }
        }

        if (seats.isEmpty()) {
            throw new OutOfPlayersException();
        }

        // deal first card face down
        seats.stream().forEach(s -> dealCard(s, false));
        dealCard(dealer, false);

        seats.stream().forEach(s -> dealCard(s, true));
        dealCard(dealer, true);

        // player actions
        seats.stream().forEach(s -> {
            s.getHand().reveal();
            while (s.shouldHit(dealerHand)) {
                dealCard(s, true);
            }
        });

        // dealer actions
        dealerHand.reveal();
        while (dealer.shouldHit()) {
            dealCard(dealer, true);
        }
        System.out.println("CARDS PLAYED");
        System.out.println(toString());
        System.out.println();

        // player resolve hands
        seats.stream().forEach(this::resolveHand);

        // dealer resolve hand
        dealerHand.clear();
        System.out.println("WINNINGS COLLECTED");
        System.out.println(toString());
        System.out.println();
    }

    private void dealCard(Player person, boolean faceUp) {
        Card card = null;
        while (card == null) {
            try {
                card = deck.draw();
            } catch (OutOfCardsException e) {
                deck = Deck.init();
                deck.shuffle();
            }
        }

        if (faceUp) {
            card.flip();
        }
        person.getHand().addCard(card);
    }

    private void resolveHand(Seat seat) {
        int handValue = seat.getHand().evaluate();
        int dealerValue = dealer.getHand().evaluate();
        if (handValue > 21) {
            seat.loseWager();
        } else if (dealerValue > 21) {
            seat.collectWinnings();
        } else if (dealerValue >= handValue) {
            seat.loseWager();
        } else {
            seat.collectWinnings();
        }
        seat.getHand().clear();
    }

    @Override
    public String toString() {
        String string = "";
        for (int i = 0; i < seats.size(); i++) {
            string += "Seat #" + (i + 1) + "\n" + seats.get(i).toString() + "\n\n";
        }
        string += "Dealer\n" + dealer.toString() + "\n\nCards left in deck: " + deck.getDeckSize();
        return string;
    }
}
