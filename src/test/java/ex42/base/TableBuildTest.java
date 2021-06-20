/*
 *  UCF COP3330 Summer 2021 Assignment 3 Solution
 *  Copyright 2021 Rielly Donnell
 *
 */

package ex42.base;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class TableBuildTest {

    @Test
    void build_test() {
        String last = "a";
        String first = "b";
        String salary = "c";
        List<Map<String, String>> l = new ArrayList<>();
        Map<String, String> record = new HashMap<>();
        record.put("Last", last);
        record.put("First", first);
        record.put("Salary", salary);
        l.add(record);
        TableBuild tst = new TableBuild(l);
        tst.build();
        var actual = tst.getOutput();
        String expected = "Last      First     Salary\n" +
                "--------------------------\n" +
                "b         a         c    \n";
        assertEquals(expected, actual);
    }

    @Test
    void getRow_test() {
    }
}