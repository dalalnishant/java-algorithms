package com.algorithms.sorting;

public class Selection extends SortAlgorithm {

    @Override
    public void sort(int[] arr) {
        validate(arr);

        if (arr.length <= 1)
            return;

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
