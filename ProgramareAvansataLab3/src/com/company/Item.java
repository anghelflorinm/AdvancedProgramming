package com.company;

public interface Item {
    double getValue();

    double getWeight();

    default double profitFactor() {
        return getValue() / getWeight();
    }
}
