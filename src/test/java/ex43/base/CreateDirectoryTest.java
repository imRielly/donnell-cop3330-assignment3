/*
 *  UCF COP3330 Summer 2021 Assignment 3 Solution
 *  Copyright 2021 Rielly Donnell
 *
 */

package ex43.base;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CreateDirectoryTest {

    @Test
    void createDirectory_test() {
        String siteName = "Test";
        String author = "Rielly";
        String js = "y";
        String css = "y";
        String root = "./website/Test/";
        CreateFiles nFiles = new CreateFiles(siteName, author, js, css, root);
        nFiles.build();
        CreateDirectory nDir = new CreateDirectory(root);
        nDir.buildDir();
        String expected = "Created ./website/Test/\n" +
                "Created ./website/Test/css\n" +
                "Created ./website/Test/index.html\n" +
                "Created ./website/Test/js\n";
        assertEquals(expected, nDir.getDir().toString());
    }

}