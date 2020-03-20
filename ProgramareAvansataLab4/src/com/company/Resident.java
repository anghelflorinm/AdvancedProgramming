package com.company;

import java.util.Objects;

public class Resident {
    private String name;

    public Resident(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Resident{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Resident)) return false;
        Resident resident = (Resident) o;
        return name.equals(resident.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
