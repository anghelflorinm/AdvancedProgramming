package com.company;

import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        Set<Player> playerSet = new HashSet<>();
        Board board = new Board(100, 8);
        int i;
        for (i = 0; i < 1; i++) {
            Player player = new RandomPlayer("Player " + i, board, playerSet, i);
            playerSet.add(player);
        }
        //playerSet.add(new ManualPlayer("Player " + i, board, playerSet, i++));
        playerSet.add(new SmartPlayer("Player " + i, board, playerSet, i++));
        board.setNextPlayer(0);
        for (Player player : playerSet) {
            new Thread(player).start();
        }
    }
}
