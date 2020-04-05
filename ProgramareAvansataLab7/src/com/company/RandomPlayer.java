package com.company;

import java.util.Set;

public class RandomPlayer extends Player {

    public RandomPlayer(String name, Board board, Set<Player> playerSet) {
        super(name, board, playerSet);
    }

    @Override
    void addToken() {
        int maxToken = board.getMaxToken();
        //System.out.println("Aici " + this.getName());
        boolean found = false;
        synchronized (board) {
            System.out.println("Choosing for " + this.getName());
            while (!found) {
                int tokenVal = (int) (Math.random() * (maxToken)) + 1;
                if (board.containsToken(new Token(tokenVal))) {
                    found = true;
                    System.out.println("Chose value " + tokenVal);
                    tokenSet.add(new Token(tokenVal));
                    board.removeToken(new Token(tokenVal));
                }
            }
        }
        System.out.println("Done!");
    }
}
