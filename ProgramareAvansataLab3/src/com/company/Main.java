package com.company;
import java.util.*;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Weapon maceta = new Weapon(Weapon.WeaponType.MACETA, 5, 8);
        Weapon lama = new Weapon(Weapon.WeaponType.LAMA, 2, 9);
        Food kiwans = new Food("Shaworma Kiwans Extra Vita Extra Cheddar", 60);
        Food fornetti = new Food("XXL Pernuta Cu Cascaval", 30);
        Book card = new Book("As De Trefla", 100, 100);
        Book carrot = new Book("Morcoveata", 700, 20);

        /*Knapsack knapsack = new Knapsack(30);
        knapsack.addItem(maceta);
        knapsack.addItem(lama);
        knapsack.addItem(kiwans);
        knapsack.addItem(fornetti);
        knapsack.addItem(card);

        System.out.println(knapsack);*/
        List<Item> items = new ArrayList<>(Arrays.asList(maceta, lama, kiwans, fornetti, card, carrot));
        Algorithm dpAlgorithm = new DymamicProgrammingAlgorithm();
        Knapsack dpKnapsack = dpAlgorithm.fillKnapsack(items, 30);
        System.out.println(dpKnapsack.toString());
        Algorithm greedyAlgorithm = new GreedyAlgorithm();
        Knapsack greedyKnapsack = greedyAlgorithm.fillKnapsack(items, 30);
        System.out.println(greedyKnapsack);
        System.out.println();
        generateRandom(10, 60);
    }

    public static void generateRandom(int min, int max){
        double capacity = Math.floor(Math.random() * (max*3)) + min;
        int nrItems = (int)Math.floor(Math.random() * max) + min;
        List<Item> items = new ArrayList<>();
        for(int i = 0; i < nrItems; i++){
            items.add(new Weapon(Weapon.WeaponType.MACETA, Math.floor(Math.random() * max) + min, Math.floor(Math.random() * max) + min));
        }
        Algorithm dpAlgorithm = new DymamicProgrammingAlgorithm();
        Knapsack dpKnapsack = dpAlgorithm.fillKnapsack(items, capacity);
        System.out.println(dpKnapsack.toString());
        Algorithm greedyAlgorithm = new GreedyAlgorithm();
        Knapsack greedyKnapsack = greedyAlgorithm.fillKnapsack(items, capacity);
        System.out.println(greedyKnapsack);
    }
}
