/*
 *  UCF COP3330 Summer 2021 Assignment 3 Solution
 *  Copyright 2021 Rielly Donnell
 *
 */

/*
Exercise 46 - Word Frequency Finder
Knowing how often a word appears in a sentence or block of text is
helpful for creating word clouds and other types of word analysis.
And it’s more useful when running it against lots of text.

Create a program that reads in a file named `exercise46_input.txt`
and counts the frequency of words in the file. Then construct a
histogram displaying the words and the frequency, and display the histogram to the screen.

Example Output
Given the text file `exercise46_input.txt` with this content

badger badger badger
badger mushroom
mushroom snake badger badger
badger

the program would produce the following output:

badger:   *******
mushroom: **
snake:    *

Constraint
Ensure that the most used word is at the top of the report and the least used words are at the bottom.
 */

package ex46.base;

import java.io.File;
import java.io.IOException;
import java.util.*;

import static java.util.stream.Collectors.toMap;

public class App {
    public static void main(String[] args) {
        //Initialize main
        String path = "./input/exercise46_input.txt";
            //String path = "./input/shrek.txt";

        //Read input file
        ArrayList<String> words = readFile(path);

        //Create map to count appearance of each word
        Map<String, Integer> counts = new HashMap();

        //Count the words
        populateCounts(counts, words);

        //Display counts
        String output = displayCounts(counts);
        System.out.println(output);
    }

    public static ArrayList<String> readFile(String path) {
        ArrayList<String> words = new ArrayList<>();
        try (Scanner file = new Scanner(new File(path))) {
            while (file.hasNext()) words.add(file.next());
        } catch(IOException e) {
        }
        return words;
    }

    public static void populateCounts(Map<String, Integer> counts, ArrayList<String> words){
        for(String word : words){
            word = word.toLowerCase();
            if (counts.containsKey(word)) {
                int count = counts.get(word);
                counts.put(word, count + 1);
            } else {
                counts.put(word, 1);
            }
        }
    }

    public static String displayCounts(Map<String, Integer> counts) {
        Map<String, Integer> sorted = counts.entrySet().stream().sorted(Collections.reverseOrder(Map.Entry.comparingByValue())).collect(toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2, LinkedHashMap::new));

        StringBuilder output = new StringBuilder();
        for(String key : sorted.keySet()) {
            String tmp = String.format("%-10s%s", key + ":", " " + "*".repeat(Math.max(0, counts.get(key))));
            output.append(tmp).append("\n");
        }
        return output.toString();
    }


}


