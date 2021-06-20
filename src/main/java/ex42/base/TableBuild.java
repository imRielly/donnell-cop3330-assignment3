/*
 *  UCF COP3330 Summer 2021 Assignment 3 Solution
 *  Copyright 2021 Rielly Donnell
 *
 */

package ex42.base;

import java.util.List;
import java.util.Map;

public class TableBuild {

    private List<Map<String, String>> in;
    private String output;

    public TableBuild(List<Map<String, String>> in){
        this.in = in;
    }

    public String getOutput() {
        return output;
    }

    public void setOutput(String output) {
        this.output = output;
    }

    public void build(){
        StringBuilder outString = new StringBuilder();
        outString.append("""
                Last      First     Salary
                --------------------------
                """);
        for (int i = 0; i < in.size(); i++) {
            outString.append(getRow(in, i));
        }
        setOutput(outString.toString());
    }

    public static String getRow(List<Map<String, String>> in, int i) {
        Map<String, String> feed = in.get(i);
        return String.format("%-10s%-10s%-5s\n",feed.get("First"), feed.get("Last"), feed.get("Salary"));
    }

}
