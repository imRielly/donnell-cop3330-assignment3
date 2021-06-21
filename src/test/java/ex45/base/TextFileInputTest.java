/*
 *  UCF COP3330 Summer 2021 Assignment 3 Solution
 *  Copyright 2021 Rielly Donnell
 *
 */

package ex45.base;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TextFileInputTest {
    @Test
    void readFileInput_test() {
        TextFileInput test = new TextFileInput("input/exercise45_input.txt");
        test.readFileInput();
        assertTrue(test.getContents().get(0).contains("One"));
    }

    @Test
    void replaceWord_test() {
        TextFileInput test = new TextFileInput("input/exercise45_input.txt");
        test.readFileInput();
        test.replaceWord("One","");
        assertFalse(test.getContents().get(0).contains("One"));
    }

    @Test
    void buildOutput_test() {
        TextFileInput test = new TextFileInput("input/exercise45_input.txt");
        test.readFileInput();
        test.buildOutput();
        assertTrue(test.getOutput().length() > 0);
    }
}