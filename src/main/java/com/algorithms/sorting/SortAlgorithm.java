package com.algorithms.sorting;

public abstract class SortAlgorithm {

    /**
     * Sorts an integer array in ascending order.
     * Each subclass must provide its own implementation.
     *
     * @param arr the array to sort
     */
    public abstract void sort(int[] arr);

    /**
     * Validates the input array.
     * Shared guard logic reusable by all subclasses.
     *
     * @param arr the array to validate
     * @throws IllegalArgumentException if the array is null
     */
    protected void validate(int[] arr) {
        if (arr == null) {
            throw new IllegalArgumentException("Array cannot be null");
        }
    }
}
