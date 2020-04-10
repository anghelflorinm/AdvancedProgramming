package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class SmartPlayer extends Player {
    public SmartPlayer(String name, Board board, Set<Player> playerSet, int id) {
        super(name, board, playerSet, id);
    }

    @Override
    void addToken() {
        System.out.println("Choosing for " + this.getName());
        List<Token> tokenList = new ArrayList<>(tokenSet);
        for (int i = 0; i < tokenList.size() - 1; i++) {
            for (int j = i + 1; j < tokenList.size(); j++) {
                int val1 = tokenList.get(i).getNumber();
                int val2 = tokenList.get(j).getNumber();
                int diff = val2 - val1;
                int currLen = 2;
                do {
                    if (!tokenSet.contains(new Token(val2 + diff))) {
                        if (board.containsToken(new Token(val2 + diff))) {
                            System.out.println("Chose value " + (val2 + diff));
                            tokenSet.add(new Token(val2 + diff));
                            board.removeToken(new Token(val2 + diff));
                            return;
                        }
                    }

                    val1 = val2;
                    val2 = val1 + diff;
                    currLen++;
                } while (tokenSet.contains(new Token(val2)));
            }
        }
        boolean found = false;
        while (!found) {
            int tokenVal = (int) (Math.random() * (board.getMaxToken())) + 1;
            if (board.containsToken(new Token(tokenVal))) {
                found = true;
                System.out.println("Chose value " + tokenVal);
                tokenSet.add(new Token(tokenVal));
                board.removeToken(new Token(tokenVal));
            }
        }
        System.out.println("Done!");
    }
}
