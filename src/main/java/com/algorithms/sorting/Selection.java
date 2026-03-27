package com.algorithms.sorting;

public class Selection {

    /**
     * Sorts an integer array in ascending order.
     * 
     * @param arr
     */
    public void sort(int[] arr) {
        if(arr == null) {
            throw new IllegalArgumentException("Array cannot be null");
        }

        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[minIndex] > arr[j]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                int min = arr[minIndex];
                arr[minIndex] = arr[i];
                arr[i] = min;
            }
        }
    }
}
