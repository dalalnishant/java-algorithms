package com.algorithms;

import java.util.Arrays;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.algorithms.sorting.Bubble;
import com.algorithms.sorting.Selection;
import com.algorithms.sorting.SortAlgorithm;

public class App {
    private static final Logger log = LoggerFactory.getLogger(App.class);

    private static final int SELECTION_SORT = 1;
    private static final int BUBBLE_SORT = 2;

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            log.info("Enter number to apply sort:");
            log.info("1. Selection sort");
            log.info("2. Bubble sort");

            if (!scanner.hasNextInt()) {
                log.error("Invalid input. Please enter a number.");
                return;
            }
            int input = scanner.nextInt();

            log.info("You chose {}, thanks", input);

            SortAlgorithm algorithm = getAlgorithm(input);
            if (algorithm == null) {
                log.error("Invalid choice: {}. Please enter {} or {}.",
                        input, SELECTION_SORT, BUBBLE_SORT);
                return;
            }

            int[] list = readArray(scanner);
            if (list == null)
                return;
            log.info("You have entered {}", Arrays.toString(list));

            algorithm.sort(list);
            log.info("Sorted result: {}", Arrays.toString(list));
        }
    }

    private static SortAlgorithm getAlgorithm(int choice) {
        switch (choice) {
            case SELECTION_SORT:
                return new Selection();
            case BUBBLE_SORT:
                return new Bubble();
            default:
                return null;
        }
    }

    private static int[] readArray(Scanner scanner) {
        log.info("How many numbers do you want to sort?");
        if (!scanner.hasNextInt()) {
            log.error("Invalid input. Please enter a number.");
            return null;
        }
        int size = scanner.nextInt();

        if (size <= 0) {
            log.error("Size must be a positive number. Got: {}", size);
            return null;
        }

        int[] list = new int[size];
        log.info("Awesome! Now enter {} numbers to sort:", size);
        for (int i = 0; i < size; i++) {
            if (!scanner.hasNextInt()) {
                log.error("Invalid input at position {}. Please enter a number.", i + 1);
                return null;
            }
            list[i] = scanner.nextInt();
        }
        return list;
    }
}
