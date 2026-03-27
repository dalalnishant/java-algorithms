package com.algorithms;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.algorithms.sorting.Selection;

public class App {
    private static final Logger log = LoggerFactory.getLogger(App.class);

    public static void main(String[] args) {
        Selection selection = new Selection();
        int[] list = { 100, 99, 98, 97, 96 };

        selection.sort(list);

        log.info("Selection sort {}", Arrays.toString(list));
    }
}
