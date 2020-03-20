package com.company;

public class Hospital  implements Comparable<Hospital>{
    private String name;
    private int capacity;

    public Hospital(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    @Override
    public String toString() {
        return "Hospital{" +
                "name='" + name + '\'' +
                ", capacity=" + capacity +
                '}';
    }


    @Override
    public int compareTo(Hospital o) {
        return this.getCapacity() - o.getCapacity();
    }
}
