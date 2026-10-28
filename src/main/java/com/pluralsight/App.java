package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Pattern;

public class App {
    public static void main(String[] args) {

        ArrayList<Product> inventory = getInventory();
        displayInventory(inventory);

    }

    private static void displayInventory(ArrayList<Product> inventory) {
        for (Product product : inventory) {
            System.out.println("ID: " + product.getId());
            System.out.println("Name: " + product.getName());
            System.out.println("Price: " + product.getPrice());
            System.out.println("--------------------");
        }
    }

    private static ArrayList<Product> getInventory() {

        ArrayList<Product> inventory = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader("inventory.csv");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;

            while ((line = bufferedReader.readLine()) != null) {
                // Split it into individual fields using the | character as the delimiter
                String[] fields = line.split(Pattern.quote("|"));

                // Fill data into product object and add to list
                int id = Integer.parseInt(fields[0]);
                String name = fields[1];
                double price = Double.parseDouble(fields[2]);
                Product product = new Product(id, name, price);
                inventory.add(product);
            }

            bufferedReader.close();

        } catch (IOException e) {
            System.out.println("There was an error reading the inventory file. Check the location of the file.");
        }
        return inventory;
    }
}