/*
 *  UCF COP3330 Summer 2021 Assignment 3 Solution
 *  Copyright 2021 Rielly Donnell
 *
 */

package ex44.base;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static ex44.base.App.getProducts;
import static ex44.base.App.search;
import static org.junit.jupiter.api.Assertions.*;

class AppTest {

    @Test
    void search_test_found_ball(){
        List<Products> sample = new ArrayList<>();
        Products sampleProduct = new Products("ball", 12.69, 5);
        sample.add(sampleProduct);
        Products actual = search(sample, "ball");
        assertEquals("ball", actual.getName());
    }

    @Test
    void search_test_not_found_ball(){
        List<Products> sample = new ArrayList<>();
        Products sampleProduct = new Products("darts", 12.69, 5);
        sample.add(sampleProduct);
        Products actual = search(sample, "ball");
        assertEquals(null, actual.getName());
    }

    @Test
    void getProducts_Test(){
        String inputPath = "input/exercise44_input.json";
        List<Products> products = getProducts(inputPath);
        assertEquals("Widget", products.get(0).getName().toString());
    }
}