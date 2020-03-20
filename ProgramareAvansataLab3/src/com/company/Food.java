package com.company;

public class Food implements Item {
    private String name;
    private double weight; // → getWeight, getValue

    public Food(String name, double weight) {
        this.name = name;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    @Override
    public double getValue() {
        return (weight*2);
    }

    @Override
    public double getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return "Food{" +
                "name='" + name + '\'' +
                ", weight=" + weight +
                '}';
    }
}
