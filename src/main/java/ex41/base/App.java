/*
 * UCF COP3330 Summer 2021 Assignment 3 Solution
 * Copyright 2021 Rielly Donnell
 */

/*
Exercise 41 - Name Sorter
Alphabetizing the contents of a file, or sorting its contents, is a great way to get comfortable manipulating a file in your program.

Create a program that reads in the following list of names from a file called `exercise41_input.txt` and sorts the list alphabetically:

Ling, Mai
Johnson, Jim
Zarnecki, Sabrina
Jones, Chris
Jones, Aaron
Swift, Geoffrey
Xiong, Fong
Then print the sorted list to a file called `exercise41_output.txt` that looks like the following example output.

Example Output
Total of 7 names
-----------------
Johnson, Jim
Jones, Aaron
Jones, Chris
Ling, Mai
Swift, Geoffrey
Xiong, Fong
Zarnecki, Sabrina
Constraint
Don't hard-code the number of names.
 */

package ex41.base;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class App {
    //static file path for easy access if it changes in the future
    static String path = "input/exercise41_input.txt";
    //static file path for output
    static String outputPath = "output/exercise41_output.txt";

    public static void main(String[] args) {
        //Create array
        NameList names = new NameList();
        //Populate the array with names from file at path
        names.readFile(path);
        //Sort the names
        names.sortNames();
        //Create output file
        createFile();
        //Write to file
        writeFile(names.getNameList());
    }

    public static void writeFile(ArrayList<String> names) {
        try (FileWriter w = new FileWriter(outputPath)) {
            String header = String.format("Total of %d names\n-----------------\n", names.size());
            w.write(header);
            for (String name : names) {
                w.append(name).append("\n");
            }
        } catch (IOException e) {
        }
    }

    public static void createFile() {
        File output = new File(outputPath);
        try {
            boolean fileCreated = output.createNewFile();
            if (!fileCreated) {
                output.delete();
                output.createNewFile();
            }
        } catch (IOException e) {
        }
    }
}
