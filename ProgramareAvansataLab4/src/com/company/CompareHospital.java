package com.company;

public class CompareHospital implements Comparable<Hospital> {
    @Override
    public int compareTo(Hospital o) {
        return o.getCapacity();
    }
}
