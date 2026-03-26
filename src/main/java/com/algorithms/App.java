package com.algorithms;

import com.algorithms.sorting.Selection;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        Selection selection = new Selection();
        int[] list = { 100, 99, 98, 97, 96 };

        selection.sort(list);

        for (int i = 0; i < list.length; i++) {
            if (i == 0) {
                System.out.print("{ ");
            }
            System.out.print(list[i]);
            if (i != list.length - 1) {
                System.out.print(", ");
            } else {
                System.out.print(" }\n");
            }
        }
    }
}
