/*
 *  UCF COP3330 Summer 2021 Assignment 3 Solution
 *  Copyright 2021 Rielly Donnell
 *
 */

package ex41.base;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class NameList{

    private ArrayList<String> nameList;

    public NameList() {
    }

    public void setNameList(ArrayList<String> a) {
        this.nameList = a;
    }

    public ArrayList<String> getNameList() {
        return nameList;
    }

    public void sortNames() {
        Collections.sort(nameList.subList(0, nameList.size()));
    }

    public void readFile(String path) {
        ArrayList<String> a = new ArrayList<>();
        try (Scanner file = new Scanner(new File(path)).useDelimiter(System.lineSeparator())) {
            while (file.hasNext()) a.add(file.next());
        } catch(IOException e) {

        }
        setNameList(a);
    }

    public String get(int i) {
        return nameList.get(i);
    }

    public int size(){
        return nameList.size();
    }
}
