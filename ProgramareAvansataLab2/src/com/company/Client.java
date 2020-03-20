package com.company;

import java.util.Objects;

public class Client {

    private String name;
    private int order;

    public void setName(String name) {
        this.name = name;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public String getName() {
        return name;
    }

    public int getOrder() {
        return order;
    }

    public Client() {
    }

    public Client(String name, int order) {
        this.name = name;
        this.order = order;
    }

    @Override
    public String toString() {
        return "Client{" +
                "name='" + name + '\'' +
                ", order=" + order +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Client)) return false;
        Client client = (Client) o;
        return order == client.order &&
                Objects.equals(name, client.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, order);
    }
}
