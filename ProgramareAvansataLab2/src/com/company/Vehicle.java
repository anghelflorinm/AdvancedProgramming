package com.company;

import java.util.Objects;

public abstract class Vehicle {
    @Override
    public String toString() {
        return "Vehicle{" +
                "name='" + name + '\'' +
                ", depot=" + depot.getName() +
                '}';
    }

    protected String name;
    private Depot depot;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Depot getDepot() {
        return depot;
    }

    protected void setDepot(Depot depot) {
        this.depot = depot;
    }

    public Vehicle(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof Vehicle)) {
            return false;
        }
        Vehicle other = (Vehicle) obj;
        return name.equals(other.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, depot);
    }
}
