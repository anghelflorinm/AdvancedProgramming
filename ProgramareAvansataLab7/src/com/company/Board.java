package com.company;

import java.util.Set;
import java.util.TreeSet;

public class Board {
    private Set<Token> tokenSet;
    private Integer maxToken;
    private Integer nextPlayer;
    private Integer nrOfPlayers;

    public Integer getNextPlayer() {
        return nextPlayer;
    }

    public void setNextPlayer(Integer nextPlayer) {
        this.nextPlayer = nextPlayer;
    }

    public Integer getNrOfPlayers() {
        return nrOfPlayers;
    }

    public void setNrOfPlayers(Integer nrOfPlayers) {
        this.nrOfPlayers = nrOfPlayers;
    }

    public Integer getProgressionLength() {
        return progressionLength;
    }

    private Integer progressionLength;

    public Integer getMaxToken() {
        return maxToken;
    }

    public Board(Integer maxNrTokens, Integer progressionLength) {
        tokenSet = new TreeSet<>();
        for (int i = 1; i <= maxNrTokens; i++) {
            tokenSet.add(new Token(i));
        }
        maxToken = maxNrTokens;
        this.progressionLength = progressionLength;
        nrOfPlayers = 0;
    }

    public Integer getTokensLeft() {
        return tokenSet.size();
    }

    public boolean removeToken(Token token) {
        if (tokenSet.contains(token)) {
            tokenSet.remove(token);
            return true;
        } else {
            return false;
        }
    }

    public boolean containsToken(Token token) {
        return tokenSet.contains(token);
    }
}
