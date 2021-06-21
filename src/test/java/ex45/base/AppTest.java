/*
 *  UCF COP3330 Summer 2021 Assignment 3 Solution
 *  Copyright 2021 Rielly Donnell
 *
 */

package ex45.base;

import org.junit.jupiter.api.Test;

import java.io.File;

import static ex45.base.App.fixFileName;
import static ex45.base.App.writeFile;
import static org.junit.jupiter.api.Assertions.*;

class AppTest {

    @Test
    void fixFileName_test_with_txt() {
        String fileName = "test.txt";
        fileName = fixFileName(fileName);
        assertEquals("test.txt", fileName);
    }

    @Test
    void fixFileName_test_without_txt() {
        String fileName = "test";
        fileName = fixFileName(fileName);
        assertEquals("test.txt", fileName);
    }

    @Test
    void writeFile_test() {
        String fileName = "JUnit/test.txt";
        TextFileInput input = new TextFileInput("input/exercise45_input.txt");
        input.readFileInput();
        input.buildOutput();
        writeFile(fileName, input);
        File test = new File("./output/ex45/JUnit/test.txt");
        assertTrue(test.exists());
        test.deleteOnExit();
    }
}