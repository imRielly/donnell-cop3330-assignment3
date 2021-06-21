/*
 *  UCF COP3330 Summer 2021 Assignment 3 Solution
 *  Copyright 2021 Rielly Donnell
 *
 */

/*
Exercise 45 - Word Finder
There will be times when you'll need to read in one file, modify it,
and then write a modified version of that file to a new file.

Given an input file named `exercise45_input.txt`, read the file and look for all occurrences of the word utilize.
Replace each occurrence with use. Write the modified file to a new file.

Example Output
Given the input file of

One should never utilize the word "utilize" in writing. Use "use" instead.
For example, "She uses an IDE to write her Java programs" instead of "She
utilizes an IDE to write her Java programs".

The program should generate

One should never use the word "use" in writing. Use "use" instead.
For example, "She uses an IDE to write her Java programs" instead of "She
uses an IDE to write her Java programs".

Constraints
Prompt for the name of the output file.
Write the output to a new file.
 */

package ex45.base;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        //Initialize main
        String inputFile = "input/exercise45_input.txt";

        //Prompt user for file name
        Scanner in = new Scanner(System.in);
        System.out.print("What would you like the new file to be named? ");
        String fileName = in.nextLine();

        //Add .txt to filename if it wasn't provided
        fileName = fixFileName(fileName);

        //Read the input file
        TextFileInput input = new TextFileInput(inputFile);
        input.readFileInput();

        //Modify the input
        String replaceVictim = "utilize";
        String replaceVictor = "use";
        input.replaceWord(replaceVictim, replaceVictor);

        //Write to new file
        input.buildOutput();
        writeFile(fileName, input);
        System.out.println(input.getOutput());
    }

    public static String fixFileName(String fileName) {
        if(!fileName.substring(fileName.length() - 4).equals(".txt")){
            fileName = fileName + ".txt";
        }
        return fileName;
    }

    public static void writeFile(String fileName, TextFileInput text) {
        try (FileWriter w = new FileWriter("./output/ex45/" + fileName)) {
            w.write(text.getOutput());
        } catch (IOException e) {
        }
    }
}
