package com.company;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Client client1 = new Client();
        client1.setName("Client 1");
        client1.setOrder(1);
        System.out.println(client1.getName());
        Client client2 = new Client("Client 2", 1);
        Client client3 = new Client("Client 3", 2);
        Client client4 = new Client("Client 2", 2);
        Client client5 = new Client("Client 3", 3);

        System.out.println(client1.toString());
        System.out.println(client2.toString());
        System.out.println(client3.toString());

        Vehicle v1 = new Car("BMW");
        Vehicle v2 = new Truck("Matiz");
        Vehicle v3 = new Drone("Cadillac");

        Depot depot1 = new Depot("Depot 1");
        Depot depot2 = new Depot("Depot 2");
        Depot depot3 = new Depot("Depot 3");

        depot1.setVehicles(v1);
        depot2.setVehicles(v2);
        depot3.setVehicles(v3);
        System.out.println(depot1.toString());
        System.out.println(depot2.toString());

        List<Depot> depots = new ArrayList<Depot>();
        depots.add(depot1);
        depots.add(depot2);
        depots.add(depot3);

        List<Client> clients = new ArrayList<Client>();
        clients.add(client1);
        clients.add(client2);
        clients.add(client3);
        clients.add(client4);
        clients.add(client5);

        Problem problem = new Problem(depots, clients);
        problem.addNode(1, 4, 7);
        problem.addNode(1, 5, 6);
        problem.addNode(2, 5, 3);
        problem.addNode(3, 5, 2);
        problem.addNode(4, 6, 1);
        problem.addNode(4, 7, 3);
        problem.addNode(5, 6, 4);
        problem.addNode(5, 7, 2);
        problem.addNode(6, 8, 3);
        problem.addNode(7, 8, 3);

        problem.solve();
        /*Tour tour  = new Tour(v1);
        tour.addClient(client1);
        tour.addClient(client3);
        System.out.println(tour);*/
    }
}
