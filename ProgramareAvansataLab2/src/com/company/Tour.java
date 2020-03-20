package com.company;

import java.util.*;

public class Tour {
    private Vehicle vehicle;
    private List<Client> clients;

    public Tour(Vehicle vehicle) {
        this.vehicle = vehicle;
        clients = new ArrayList<Client>();
    }

    public Tour() {
    }

    public boolean addClient(Client client) {
        if (clients.size() == 0 || clients.get(clients.size() - 1).getOrder() > client.getOrder()) {
            return false;
        }
        clients.add(client);
        return true;
    }

    @Override
    public String toString() {
        return "Tour{" +
                "vehicle=" + vehicle +
                ", clients=" + clients +
                '}';
    }
}
