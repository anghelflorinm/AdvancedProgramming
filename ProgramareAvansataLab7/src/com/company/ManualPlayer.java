package com.company;
import java.util.Scanner;

import java.util.Set;

public class ManualPlayer extends  Player{
    public ManualPlayer(String name, Board board, Set<Player> playerSet, int id) {
        super(name, board, playerSet, id);
    }

    @Override
    void addToken() {
        boolean valid = false;Scanner keyboard = new Scanner(System.in);
        while (!valid){
            System.out.println("Enter a number");
            int tokenVal = keyboard.nextInt();
            if (board.containsToken(new Token(tokenVal))) {
                valid = true;
                System.out.println("Chose value " + tokenVal);
                tokenSet.add(new Token(tokenVal));
                board.removeToken(new Token(tokenVal));
            }
        }


    }
}
