package com.company;

import java.util.*;

public class Problem {
    private List<Depot> depots;
    private List<Client> clients;
    private Set<Integer> depotNodes;
    private Set<Integer> clientNodes;
    private Stack<Integer> topologicStack;
    private boolean viz[];
    int maxNode;
    private int[][] matrix;

    private void initNodes() {
        int node = 0;
        depotNodes = new HashSet<Integer>();
        clientNodes = new HashSet<Integer>();
        for (Depot depot : depots) {
            node++;
            depotNodes.add(node);
        }
        for (Client client : clients) {
            node++;
            clientNodes.add(node);
        }
        matrix = new int[depotNodes.size() + clientNodes.size() + 1][depotNodes.size() + clientNodes.size() + 1];
    }

    public void addNode(int source, int destination, int time) {
        if (matrix[destination][source] == 0) {
            matrix[source][destination] = time;
        }
    }

    void DFS(int node) {
        viz[node] = true;
        for (int i = 1; i <= maxNode; i++) {
            if (matrix[node][i] > 0 && !viz[i]) {
                DFS(i);
            }
        }
        topologicStack.push(node);
    }

    public void solve() {
        int totalCost = 0;
        maxNode = depotNodes.size() + clientNodes.size();
        viz = new boolean[depotNodes.size() + clientNodes.size() + 1];
        List<Integer> topologicalSort = new ArrayList<>();
        topologicalSort.add(0);
        for (int i = 1; i < maxNode; i++) {
            if (!viz[i]) {
                DFS(i);
            }
        }
        while (!topologicStack.isEmpty()) {
            topologicalSort.add(topologicStack.pop());
        }

        viz = new boolean[depotNodes.size() + clientNodes.size() + 1];


        for (int depotNode : depotNodes) {
            int[] dist = new int[maxNode + 1];
            int[] pred = new int[maxNode + 1];
            for (int i = 1; i <= maxNode; i++) {
                if (i != depotNode) {
                    dist[i] = Integer.MAX_VALUE;
                    pred[i] = -1;
                }
            }
            for (int i = 1; i <= maxNode; i++) {
                int node  = topologicalSort.get(i);
                for (int j = 1; j <= maxNode; j++) {
                    if (matrix[node][j] > 0 && !viz[node] && !viz[j]) {
                        if (dist[j] > dist[node] + matrix[node][j] && (dist[node] + matrix[node][j]) >= 0) {
                            dist[j] = dist[node] + matrix[node][j];
                            pred[j] = node;
                        }
                    }
                }
            }
            Stack<Integer> trip = new Stack<>();
            int currNode = maxNode;
            while (dist[currNode] == Integer.MAX_VALUE) {
                currNode--;
            }
            totalCost += dist[currNode];
            while (dist[currNode] > 0) {
                viz[currNode] = true;
                trip.push(currNode);
                currNode = pred[currNode];
            }
            System.out.print("Trip: " + currNode);
            while (!trip.isEmpty()) {
                System.out.print(" -> " + trip.pop());
            }
            System.out.println();
        }
        System.out.println("Cost total: " + totalCost);
    }

    public Problem(List<Depot> depots, List<Client> clients) {
        this.depots = depots;
        this.clients = clients;
        topologicStack = new Stack<>();
        initNodes();
    }

    @Override
    public String toString() {
        return "Problem{" +
                "depots=" + depots +
                ", clients=" + clients +
                '}';
    }

    public void addClient(Client client) {
        if (clients.contains(client)) {
            return;
        }
        clients.add(client);
    }

    public void addDepot(Depot depot) {
        if (depots.contains(depot)) {
            return;
        }
        depots.add(depot);
    }

    public List<Vehicle> getVehicles() {
        List<Vehicle> vehicles = new ArrayList<>();
        for (Depot depot : depots) {
            Collections.addAll(vehicles, depot.getVehicles());
        }
        return vehicles;
    }
}
