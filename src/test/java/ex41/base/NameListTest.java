/*
 *  UCF COP3330 Summer 2021 Assignment 3 Solution
 *  Copyright 2021 Rielly Donnell
 *
 */

package ex41.base;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static ex41.base.App.*;
import static org.junit.jupiter.api.Assertions.*;

class NameListTest {

    @Test
    void sortNames_test() {
        ArrayList<String> set = new ArrayList<>();
        set.add("c");
        set.add("b");
        set.add("a");
        NameList sorted = new NameList();
        sorted.setNameList(set);
        sorted.sortNames();
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < sorted.size(); i++) {
            s.append(sorted.get(i));
        }
        assertEquals("abc", s.toString());
    }

    @Test
    void readFile_test() {
        createFile();
        ArrayList<String> set = new ArrayList<>();
        set.add("c");
        set.add("b");
        set.add("a");
        writeFile(set);
        NameList actual = new NameList();
        actual.readFile(outputPath);
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < actual.size(); i++) {
            s.append(actual.get(i));
        }
        assertEquals("Total of 3 names\n-----------------\nc\nb\na\n",
                s.toString());
    }
}