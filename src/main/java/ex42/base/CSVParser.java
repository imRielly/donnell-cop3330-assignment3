/*
 *  UCF COP3330 Summer 2021 Assignment 3 Solution
 *  Copyright 2021 Rielly Donnell
 *
 */

package ex42.base;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class CSVParser {

    private String path;

    public CSVParser(String path) {
        this.path = path;
    }
    public List<Map<String, String>> parsed(){
        ArrayList<String> in = new ArrayList<>();
        List<Map<String, String>> output = new ArrayList<>();
        try (Scanner file = new Scanner(new File(path)).useDelimiter(System.lineSeparator())) {
            while (file.hasNext()) in.add(file.next());
        } catch(IOException e) {
        }
        for (String s : in) {
            String[] splits = s.split(",");
            Map<String, String> record = new HashMap<>();
            record.put("Last", splits[0]);
            record.put("First", splits[1]);
            record.put("Salary", splits[2]);
            output.add(record);
        }
        return output;
    }

}
