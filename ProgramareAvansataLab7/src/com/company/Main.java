package com.company;

import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        Set<Player> playerSet = new HashSet<>();
        Board board = new Board(20, 3);

        for (int i = 0; i < 2; i++) {
            Player player = new RandomPlayer("Player " + i, board, playerSet);
            playerSet.add(player);
        }

        for (Player player : playerSet) {
            new Thread(player).start();
        }
    }
}
