package com.company;

import java.util.List;
import java.util.Stack;

public class DymamicProgrammingAlgorithm implements Algorithm {
    @Override
    public Knapsack fillKnapsack(List<Item> avalilableItems, double capacity) {
        int nrObjects = avalilableItems.size();
        capacity = (int) capacity;
        Knapsack solutionKnapsack = new Knapsack(capacity);
        int[][] dpMatrix = new int[nrObjects + 1][(int) capacity + 1];
        for (int i = 1; i <= nrObjects; i++) {
            for (int j = 0; j <= capacity; j++) {
                if (j < (int) avalilableItems.get(i - 1).getWeight()) {
                    dpMatrix[i][j] = dpMatrix[i - 1][j];
                } else {
                    dpMatrix[i][j] = Math.max(dpMatrix[i - 1][j], dpMatrix[i - 1][j - (int) avalilableItems.get(i - 1).getWeight()] + (int) avalilableItems.get(i - 1).getValue());
                }
            }
        }
        int result = dpMatrix[nrObjects][(int) capacity];
        int tempCapacity = (int) capacity;
        for (int i = nrObjects; i > 0 && result > 0; i--) {
            if (result != dpMatrix[i - 1][tempCapacity]) {
                solutionKnapsack.addItem(avalilableItems.get(i - 1));
                result = result - (int) avalilableItems.get(i - 1).getValue();
                tempCapacity = tempCapacity - (int) avalilableItems.get(i - 1).getWeight();
            }
        }
        return solutionKnapsack;
    }
}
