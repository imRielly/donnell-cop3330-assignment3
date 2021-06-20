/*
 *  UCF COP3330 Summer 2021 Assignment 3 Solution
 *  Copyright 2021 Rielly Donnell
 *
 */

package ex41.base;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import static ex41.base.App.*;
import static org.junit.jupiter.api.Assertions.*;

class AppTest {

    @Test
    void createFile_fileExists() {
        String outputPath = "input/exercise41_input.txt";
        createFile();
        File tryToCreate = new File(outputPath);
        boolean fileWasMissing = false;
        try {
            fileWasMissing = tryToCreate.createNewFile();
        } catch (IOException e) {
        }

        assertFalse(fileWasMissing);

    }

    @Test
    void writeFile_WriteToFile() {
        createFile();
        ArrayList<String> testInput = new ArrayList<>();
        String testStr = "Donnell, Rielly";
        testInput.add(testStr);
        writeFile(testInput);
        ArrayList<String> a = new ArrayList<>();
        try (Scanner file = new Scanner(new File(outputPath)).useDelimiter(System.lineSeparator())) {
            while (file.hasNext()) a.add(file.next());
        } catch(IOException e) {

        }
        String expected = String.format("Total of 1 names\n-----------------\n%s\n", testStr);
        assertEquals(expected, a.get(0));
    }
}