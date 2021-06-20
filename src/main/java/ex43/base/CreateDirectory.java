/*
 *  UCF COP3330 Summer 2021 Assignment 3 Solution
 *  Copyright 2021 Rielly Donnell
 *
 */

package ex43.base;

import java.io.File;

public class CreateDirectory {
    private String root;
    private StringBuilder dir;

    public StringBuilder getDir() {
        return dir;
    }

    public void setDir(StringBuilder dir) {
        this.dir = dir;
    }

    public CreateDirectory(String root){
        this.root = root;
    }

    public void buildDir(){
        String[] contents = new File(root).list();
        StringBuilder tmp = new StringBuilder();
        tmp.append("Created ").append(root).append("\n");
        for(String file: contents) {
            tmp.append("Created ").append(root).append(file).append("\n");
        }
        setDir(tmp);
    }
}
