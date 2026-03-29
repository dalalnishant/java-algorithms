package com.algorithms;

import java.util.Arrays;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.algorithms.sorting.Bubble;
import com.algorithms.sorting.Selection;

public class App {
    private static final Logger log = LoggerFactory.getLogger(App.class);

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        log.info("Enter number to apply sort:\n");
        log.info("1. Selection sort\n");
        log.info("2. Bubble sort\n");

        int input = scanner.nextInt();
        if (input < 1 || input > 2) {
            log.error("Invalid choice: {}. Please enter 1 or 2.", input);
            scanner.close();
            return;
        }

        log.info("You chose {}, thanks", input);

        log.info("How many numbers do you want to sort?");
        int size = scanner.nextInt();
        int[] list = new int[size];
        log.info("Awesome! Now enter numbers you want to sort");
        for (int i = 0; i < size; i++) {
            list[i] = scanner.nextInt();
        }
        log.info("You have entered {}", Arrays.toString(list));

        switch (input) {
            case 1:
                Selection selection = new Selection();
                selection.sort(list);
                log.info("Sorted using Selection sort: {}", Arrays.toString(list));
                break;

            case 2:
                Bubble bubble = new Bubble();
                bubble.sort(list);
                log.info("Sorted using Bubble sort: {}", Arrays.toString(list));
                break;

            default:
                log.warn("Invalid choice: {}", input);
                break;
        }
        scanner.close();
    }
}
