/*
 *  UCF COP3330 Summer 2021 Assignment 3 Solution
 *  Copyright 2021 Rielly Donnell
 *
 */

package ex46.base;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static ex46.base.App.*;
import static org.junit.jupiter.api.Assertions.*;

class AppTest {

    @Test
    void readFile_test() {
        ArrayList<String> actual = readFile("./input/exercise46_input.txt");
        assertEquals("badger", actual.get(0));

    }

    @Test
    void populateCounts_test() {
        String path = "./input/exercise46_input.txt";
        ArrayList<String> words = readFile(path);
        Map<String, Integer> counts = new HashMap();

        populateCounts(counts, words);

        assertTrue(!counts.isEmpty());
    }

    @Test
    void displayCounts_test() {
        String path = "./input/exercise46_input.txt";
        ArrayList<String> words = readFile(path);
        Map<String, Integer> counts = new HashMap();
        populateCounts(counts, words);

        //Display counts
        String actual = displayCounts(counts);
        assertEquals("badger:    *******\n" +
                "mushroom:  **\n" +
                "snake:     *\n", actual);
    }
}