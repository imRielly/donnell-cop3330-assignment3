/*
 *  UCF COP3330 Summer 2021 Assignment 3 Solution
 *  Copyright 2021 Rielly Donnell
 *
 */
/*
Exercise 44 - Product Search
Pulling data from a file into a complex data structure makes parsing much simpler.
Many programming languages support the JSON format, a popular way of representing data.

Create a program that takes a product name as input and retrieves the current
price and quantity for that product. The product data is in a data file in the JSON format
and looks like this (you will create this file as `exercise44_input.json`):

{
    "products" : [
        {"name": "Widget", "price": 25.00, "quantity": 5 },
        {"name": "Thing", "price": 15.00, "quantity": 5 },
        {"name": "Doodad", "price": 5.00, "quantity": 10 }
    ]
}

Print out the product name, price, and quantity if the product is found.
If no product matches the search, state that no product was found and start over.

Example Output
What is the product name? iPad
Sorry, that product was not found in our inventory.
What is the product name? Galaxy
Sorry, that product was not found in our inventory.
What is the product name? Thing
Name: Thing
Price: 15.00
Quantity: 5

Constraints
The file is in the JSON format.
Use a JSON parser to pull the values out of the file (e.g. https://github.com/google/gson
(Links to an external site.)).
If no record is found, prompt again.
 */
package ex44.base;

import com.google.gson.*;

import java.io.*;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    public static Scanner in = new Scanner(System.in);
    public static void main(String[] args) {
        //Initialize main
        String inputPath = "input/exercise44_input.json";
        String output = null;
        //Parse JSON file
        List<Products> products = getProducts(inputPath);
        //Search for input (loop if none)
        output = searchForProduct(products);
        //Print out search result
        System.out.println(output);
    }

    public static List<Products> getProducts(String inputPath) {
        File input = new File(inputPath);
        List<Products> products = null;
        try {
            JsonElement fileElement = JsonParser.parseReader(new FileReader(input));
            JsonObject fileObject = fileElement.getAsJsonObject();
            JsonArray jsonArrayProducts = fileObject.get("products").getAsJsonArray();
            products = new ArrayList<>();
            for (JsonElement productJson : jsonArrayProducts) {
                JsonObject productJsonObject = productJson.getAsJsonObject();

                String name = productJsonObject.get("name").getAsString();
                int price = productJsonObject.get("price").getAsInt();
                int quantity = productJsonObject.get("quantity").getAsInt();

                Products product = new Products(name, price, quantity);
                products.add(product);
            }
        } catch (FileNotFoundException e) {
        }
        return products;
    }

    private static String searchForProduct(List<Products> products) {
        String search;
        String foundName;
        double foundPrice;
        int foundQuantity;
        String output = null;
        do{
            System.out.print("What is the product name? ");
            search = in.nextLine().toLowerCase();
            Products foundProduct = search(products, search);
            foundName = foundProduct.getName();
            foundPrice = foundProduct.getPrice();
            foundQuantity = foundProduct.getQuantity();
            if(foundName == null){
                System.out.println("Sorry, that product was not found in our inventory.");
            } else {
                DecimalFormat df = new DecimalFormat("0.00");
                output = String.format("Name: %s\nPrice: $%s\nQuantity: %d", foundName, df.format(foundPrice), foundQuantity);
            }
        } while(foundName == null);
        return output;
    }

    public static Products search(List<Products> products, String search){

        if (products != null) {
            for(Products p : products){
                if(p.getName() != null && p.getName().toLowerCase().contains(search)){
                    return p;
                }
            }
        }
        Products none = new Products(null,0,0);
        return none;
    }
}
