package com.pluralsight;

import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        ArrayList<Product> inventory = getInventory();
        displayInventory(inventory);

    }

    private static void displayInventory(ArrayList<Product> inventory) {
        for (Product product : inventory) {
            System.out.println("id: " + product.getId());
            System.out.println("Name: " + product.getName());
            System.out.println("Price: " + product.getPrice());
        }
    }

    private static ArrayList<Product> getInventory() {
        ArrayList<Product> inventory = new ArrayList<>();

        inventory.add(new Product(5555, "Coffee Beans", 29.99));
        inventory.add(new Product(6452, "Coffee Cups", 14.85));
        inventory.add(new Product(5241, "Banana Bread", 2.29));
        inventory.add(new Product(6472, "Coffee Pots", 35.99));
        inventory.add(new Product(8972, "Coffee filters", 19.65));
        return inventory;
    }

}
