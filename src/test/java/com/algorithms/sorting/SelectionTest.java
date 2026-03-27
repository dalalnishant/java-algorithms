package com.algorithms.sorting;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SelectionTest {

    private Selection selection;

    @BeforeEach
    void setUp() {
        selection = new Selection();
    }

    // --- Core Cases ---

    @Test
    void testAlreadySortedArray() {
        int[] arr = { 1, 2, 3, 4, 5 };
        selection.sort(arr);
        assertArrayEquals(new int[] { 1, 2, 3, 4, 5 }, arr);
    }

    @Test
    void testReverseSortedArray() {
        int[] arr = { 5, 4, 3, 2, 1 };
        selection.sort(arr);
        assertArrayEquals(new int[] { 1, 2, 3, 4, 5 }, arr);
    }

    @Test
    void testRandomUnsortedArray() {
        int[] arr = { 64, 25, 12, 22, 11 };
        selection.sort(arr);
        assertArrayEquals(new int[] { 11, 12, 22, 25, 64 }, arr);
    }

    // --- Edge Cases ---

    @Test
    void testSingleElement() {
        int[] arr = { 42 };
        selection.sort(arr);
        assertArrayEquals(new int[] { 42 }, arr);
    }

    @Test
    void testTwoElements() {
        int[] arr = { 9, 1 };
        selection.sort(arr);
        assertArrayEquals(new int[] { 1, 9 }, arr);
    }

    @Test
    void testAllElementsEqual() {
        int[] arr = { 7, 7, 7, 7 };
        selection.sort(arr);
        assertArrayEquals(new int[] { 7, 7, 7, 7 }, arr);
    }

    @Test
    void testDuplicateValues() {
        int[] arr = { 3, 1, 2, 1, 3 };
        selection.sort(arr);
        assertArrayEquals(new int[] { 1, 1, 2, 3, 3 }, arr);
    }

    @Test
    void testNegativeNumbers() {
        int[] arr = { -3, -1, -7, -4 };
        selection.sort(arr);
        assertArrayEquals(new int[] { -7, -4, -3, -1 }, arr);
    }

    @Test
    void testMixedNegativeAndPositive() {
        int[] arr = { 3, -2, 0, -5, 8 };
        selection.sort(arr);
        assertArrayEquals(new int[] { -5, -2, 0, 3, 8 }, arr);
    }

    @Test
    void testIntegerBoundaryValues() {
        int[] arr = { Integer.MAX_VALUE, 0, Integer.MIN_VALUE };
        selection.sort(arr);
        assertArrayEquals(new int[] { Integer.MIN_VALUE, 0, Integer.MAX_VALUE }, arr);
    }

    // --- Defensive Cases ---

    @Test
    void testEmptyArray() {
        int[] arr = {};
        assertDoesNotThrow(() -> selection.sort(arr));
    }

    @Test
    void testNullArrayThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> selection.sort(null));
    }
}