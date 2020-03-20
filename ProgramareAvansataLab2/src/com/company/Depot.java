package com.company;

import java.util.Arrays;
import java.util.Objects;

public class Depot {
    private String name;
    private Vehicle[] vehicles;

    public Depot(String name) {
        this.name = name;
    }

    public Vehicle[] getVehicles() {
        return vehicles;
    }

    /**
     * @return Returns Depot name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @param vehicles
     */
    public void setVehicles(Vehicle... vehicles) {
        this.vehicles = vehicles;
        for (Vehicle v : vehicles) {
            v.setDepot(this);
        }
    }

    /**
     * @return
     */
    @Override
    public String toString() {
        return "Depot{" +
                "name='" + name + '\'' +
                ", vehicles=" + Arrays.toString(vehicles) +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Depot)) return false;
        Depot depot = (Depot) o;
        return Objects.equals(name, depot.name) &&
                Arrays.equals(vehicles, depot.vehicles);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(name);
        result = 31 * result + Arrays.hashCode(vehicles);
        return result;
    }
}
