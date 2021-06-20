/*
 *  UCF COP3330 Summer 2021 Assignment 3 Solution
 *  Copyright 2021 Rielly Donnell
 *
 */

package ex43.base;

import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

class CreateFilesTest {

    @Test
    void build_test() {
        String siteName = "Test";
        String author = "Rielly";
        String js = "y";
        String css = "y";
        String root = "./website/Test/";
        String fPath = root + "index.html";
        File before = new File(fPath);
        before.delete();
        CreateFiles buildTest = new CreateFiles(siteName, author, js, css, root);
        buildTest.build();
        File f = new File(fPath);
        assertTrue(f.exists());
    }
}