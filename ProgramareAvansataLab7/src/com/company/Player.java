package com.company;

import java.util.*;

public abstract class Player implements Runnable {
    protected Set<Token> tokenSet;
    protected Set<Player> playerSet;
    protected final Board board;
    protected boolean running;

    public String getName() {
        return name;
    }

    protected String name;

    public void setRunning(boolean running) {
        this.running = running;
    }

    abstract void addToken();

    @Override
    public void run() {
        while (running) {
            addToken();
            if (running) {
                checkArithmeticProgression();
            }
            synchronized (board) {
                if (!running) {
                    break;
                }
                if (board.getTokensLeft() == 0) {
                    System.out.println("No tokens left");
                    for (Player player : playerSet) {
                        player.setRunning(false);
                    }
                }
            }
        }
    }

    private void checkArithmeticProgression() {
        int requiredLength = board.getProgressionLength();
        List<Token> tokenList = new ArrayList<>(tokenSet);
        for (int i = 0; i < tokenList.size() - 1; i++) {
            for (int j = i + 1; j < tokenList.size(); j++) {
                int val1 = tokenList.get(i).getNumber();
                int val2 = tokenList.get(j).getNumber();
                int diff = val2 - val1;
                int currLen = 2;
                do {
                    if (currLen >= requiredLength) {
                        for (Player player : playerSet) {
                            player.setRunning(false);
                        }
                        System.out.println("Player " + this.getName() + " won!");
                    }
                    val1 = val2;
                    val2 = val1 + diff;
                    currLen++;
                } while (tokenSet.contains(new Token(val2)));
            }
        }
    }

    public Player(String name, Board board, Set<Player> playerSet) {
        tokenSet = new TreeSet<>();
        this.board = board;
        this.playerSet = playerSet;
        running = true;
        this.name = name;
    }
}
