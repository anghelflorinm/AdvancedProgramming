package com.company;

public class Token implements Comparable<Token> {
    private Integer number;

    public Integer getNumber() {
        return number;
    }

    public Token(Integer number) {
        this.number = number;
    }

    @Override
    public int compareTo(Token t) {
        return this.getNumber() - t.getNumber();
    }
}
