/*
 *  UCF COP3330 Summer 2021 Assignment 3 Solution
 *  Copyright 2021 Rielly Donnell
 *
 */

/*
Exercise 43 - Website Generator
Programming languages can create files and folders too.

Create a program that generates a website skeleton with the following specifications:

Prompt for the name of the site.
Prompt for the author of the site.
Ask if the user wants a folder for JavaScript files.
Ask if the user wants a folder for CSS files.
Generate an index.html file that contains the name of the site inside
the <title> tag and the author in a <meta> tag.

Example Output
Site name: awesomeco
Author: Max Power
Do you want a folder for JavaScript? y
Do you want a folder for CSS? y
Created ./website/awesomeco
Created ./website/awesomeco/index.html
Created ./website/awesomeco/js/
Created ./website/awesomeco/css/

The user should then find these files and directories created in the working directory of your program.
 */

package ex43.base;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class App {
    public static Scanner in = new Scanner(System.in);
    public static void main(String[] args) {
        //Prompt for info and options
        System.out.print("Site name: ");
        String siteName = in.nextLine();
        System.out.print("Author: ");
        String author = in.nextLine();
        System.out.print("Do you want a folder for JavaScript? ");
        String js = in.nextLine();
        System.out.print("Do you want a folder for css? ");
        String css = in.nextLine();
        String root = String.format("./website/%s/", siteName);

        //Create Files
        CreateFiles cFiles = new CreateFiles(siteName, author, js, css, root);
        cFiles.build();
        //Create website directory
        CreateDirectory dir = new CreateDirectory(root);
        dir.buildDir();
        //Print website directory
        System.out.println(dir.getDir().toString());
    }
}
