package com.company;

public class Book implements Item {
    private String name;
    private int pageNumber;
    private double value;

    public Book(String name, int pageNumber, double value) {
        this.name = name;
        this.pageNumber = pageNumber;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    @Override
    public double getValue() {
        return value;
    }

    @Override
    public double getWeight() {
        return (double)pageNumber/(double)100;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", pageNumber=" + pageNumber +
                ", value=" + value +
                "weight=" + getWeight() +
                '}';
    }
}
