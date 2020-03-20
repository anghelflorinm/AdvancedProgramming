package com.company;

import java.util.Comparator;
import java.util.List;

public class GreedyAlgorithm implements Algorithm {
    @Override
    public Knapsack fillKnapsack(List<Item> avalilableItems, double capacity) {
        Knapsack solutionKnapsack = new Knapsack(capacity);

        avalilableItems.sort(Comparator.comparingDouble(Item::profitFactor));
        int currentCapacity = 0;
        for (int i = 0; i < avalilableItems.size(); i++) {
            if (currentCapacity + avalilableItems.get(i).getWeight() <= (int) capacity) {
                currentCapacity += avalilableItems.get(i).getWeight();
                solutionKnapsack.addItem(avalilableItems.get(i));
            } else {
                break;
            }
        }
        return solutionKnapsack;
    }
}
