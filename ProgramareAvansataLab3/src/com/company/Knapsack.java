package com.company;

import java.util.*;

public class Knapsack {
    private double capacity;
    private List<Item> items;
    //… constructors, getters, setters

    public Knapsack(double capacity) {
        this.capacity = capacity;
        items = new ArrayList<>();
    }

    public void addItem(Item item) {
        items.add(item);
    }

    private  int getProfit(){
        int sum = 0;
        for(Item item : items){
            sum += item.getValue();
        }
        return sum;
    }

    @Override
    public String toString() {
        items.sort(Comparator.comparingDouble(Item::profitFactor));
        return "Knapsack{" +
                "profit = " + getProfit() +
                " nrElements = " + items.size() +
                " capacity=" + capacity +
                ", items=" + items +
                '}';
    }

}