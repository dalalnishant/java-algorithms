package com.algorithms.sorting;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Selection Sort")
class SelectionTest {

    private SortAlgorithm sorter;

    @BeforeEach
    void setUp() {
        sorter = new Selection();
    }

    // -------------------------------------------------------------------------
    // 1. Guard clause tests
    // -------------------------------------------------------------------------

    @Nested
    @DisplayName("Guard clauses")
    class GuardClauses {

        @Test
        @DisplayName("Throws IllegalArgumentException when array is null")
        void throwsOnNullArray() {
            assertThrows(IllegalArgumentException.class, () -> sorter.sort(null));
        }

        @Test
        @DisplayName("Returns immediately for empty array without throwing")
        void emptyArrayIsNoOp() {
            int[] arr = {};
            assertDoesNotThrow(() -> sorter.sort(arr));
            assertArrayEquals(new int[] {}, arr);
        }

        @Test
        @DisplayName("Returns immediately for single-element array without throwing")
        void singleElementIsNoOp() {
            int[] arr = { 42 };
            assertDoesNotThrow(() -> sorter.sort(arr));
            assertArrayEquals(new int[] { 42 }, arr);
        }
    }

    // -------------------------------------------------------------------------
    // 2. Already-sorted input
    // -------------------------------------------------------------------------

    @Nested
    @DisplayName("Already sorted input")
    class AlreadySorted {

        @Test
        @DisplayName("Two elements already in order")
        void twoElementsOrdered() {
            int[] arr = { 1, 2 };
            sorter.sort(arr);
            assertArrayEquals(new int[] { 1, 2 }, arr);
        }

        @Test
        @DisplayName("Many elements already in ascending order")
        void manyElementsOrdered() {
            int[] arr = { 1, 2, 3, 4, 5, 6, 7 };
            sorter.sort(arr);
            assertArrayEquals(new int[] { 1, 2, 3, 4, 5, 6, 7 }, arr);
        }
    }

    // -------------------------------------------------------------------------
    // 3. Reverse-sorted input (worst case — maximum comparisons)
    // -------------------------------------------------------------------------

    @Nested
    @DisplayName("Reverse sorted input")
    class ReverseSorted {

        @Test
        @DisplayName("Two elements in reverse order")
        void twoElementsReversed() {
            int[] arr = { 2, 1 };
            sorter.sort(arr);
            assertArrayEquals(new int[] { 1, 2 }, arr);
        }

        @Test
        @DisplayName("Many elements in reverse order")
        void manyElementsReversed() {
            int[] arr = { 9, 7, 5, 3, 1 };
            sorter.sort(arr);
            assertArrayEquals(new int[] { 1, 3, 5, 7, 9 }, arr);
        }
    }

    // -------------------------------------------------------------------------
    // 4. General / unsorted input
    // -------------------------------------------------------------------------

    @Nested
    @DisplayName("General unsorted input")
    class GeneralUnsorted {

        @Test
        @DisplayName("Small unsorted array is sorted correctly")
        void smallUnsorted() {
            int[] arr = { 5, 3, 8, 1, 9, 2 };
            sorter.sort(arr);
            assertArrayEquals(new int[] { 1, 2, 3, 5, 8, 9 }, arr);
        }

        @Test
        @DisplayName("Larger unsorted array is sorted correctly")
        void largerUnsorted() {
            int[] arr = { 64, 25, 12, 22, 11, 90, 34 };
            sorter.sort(arr);
            assertArrayEquals(new int[] { 11, 12, 22, 25, 34, 64, 90 }, arr);
        }
    }

    // -------------------------------------------------------------------------
    // 5. Duplicate values
    // -------------------------------------------------------------------------

    @Nested
    @DisplayName("Duplicate values")
    class DuplicateValues {

        @Test
        @DisplayName("Array with all identical elements remains unchanged")
        void allIdentical() {
            int[] arr = { 7, 7, 7, 7 };
            sorter.sort(arr);
            assertArrayEquals(new int[] { 7, 7, 7, 7 }, arr);
        }

        @Test
        @DisplayName("Array with some duplicates is sorted correctly")
        void someDuplicates() {
            int[] arr = { 4, 2, 4, 1, 2 };
            sorter.sort(arr);
            assertArrayEquals(new int[] { 1, 2, 2, 4, 4 }, arr);
        }

        @Test
        @DisplayName("Array with all duplicates except one outlier")
        void oneOutlier() {
            int[] arr = { 5, 5, 5, 1, 5 };
            sorter.sort(arr);
            assertArrayEquals(new int[] { 1, 5, 5, 5, 5 }, arr);
        }
    }

    // -------------------------------------------------------------------------
    // 6. Negative and mixed-sign values
    // -------------------------------------------------------------------------

    @Nested
    @DisplayName("Negative and mixed-sign values")
    class NegativeValues {

        @Test
        @DisplayName("Array with all negative values is sorted correctly")
        void allNegative() {
            int[] arr = { -3, -1, -7, -5 };
            sorter.sort(arr);
            assertArrayEquals(new int[] { -7, -5, -3, -1 }, arr);
        }

        @Test
        @DisplayName("Array mixing negative and positive values is sorted correctly")
        void mixedSignValues() {
            int[] arr = { 3, -2, 0, -5, 4, 1 };
            sorter.sort(arr);
            assertArrayEquals(new int[] { -5, -2, 0, 1, 3, 4 }, arr);
        }

        @Test
        @DisplayName("Array containing zeros is sorted correctly")
        void containsZeros() {
            int[] arr = { 0, -1, 0, 2, 0 };
            sorter.sort(arr);
            assertArrayEquals(new int[] { -1, 0, 0, 0, 2 }, arr);
        }
    }

    // -------------------------------------------------------------------------
    // 7. Boundary / extreme values
    // -------------------------------------------------------------------------

    @Nested
    @DisplayName("Boundary values")
    class BoundaryValues {

        @Test
        @DisplayName("Array containing Integer.MIN_VALUE and Integer.MAX_VALUE")
        void integerExtremes() {
            int[] arr = { Integer.MAX_VALUE, 0, Integer.MIN_VALUE };
            sorter.sort(arr);
            assertArrayEquals(new int[] { Integer.MIN_VALUE, 0, Integer.MAX_VALUE }, arr);
        }

        @Test
        @DisplayName("Two-element array with min and max values")
        void minMaxTwoElements() {
            int[] arr = { Integer.MAX_VALUE, Integer.MIN_VALUE };
            sorter.sort(arr);
            assertArrayEquals(new int[] { Integer.MIN_VALUE, Integer.MAX_VALUE }, arr);
        }
    }

    // -------------------------------------------------------------------------
    // 8. Selection sort is NOT stable — equal elements may not retain order.
    // We verify only that the output values are correct, not their positions.
    // -------------------------------------------------------------------------

    @Nested
    @DisplayName("Correctness with duplicates (unstable sort)")
    class DuplicateCorrectness {

        @Test
        @DisplayName("Interleaved duplicates are grouped and ordered correctly")
        void interleavedDuplicates() {
            int[] arr = { 3, 1, 3, 1, 3 };
            sorter.sort(arr);
            assertArrayEquals(new int[] { 1, 1, 3, 3, 3 }, arr);
        }
    }

    // -------------------------------------------------------------------------
    // 9. Parameterised: multiple unsorted → expected sorted pairs
    // -------------------------------------------------------------------------

    static Stream<int[][]> unsortedPairs() {
        return Stream.of(
                new int[][] { { 10, 9, 8 }, { 8, 9, 10 } },
                new int[][] { { 1, 3, 2, 5, 4 }, { 1, 2, 3, 4, 5 } },
                new int[][] { { -10, 0, 5, -3, 8, -1 }, { -10, -3, -1, 0, 5, 8 } },
                new int[][] { { 100 }, { 100 } },
                new int[][] { { 2, 2, 1, 1 }, { 1, 1, 2, 2 } });
    }

    @ParameterizedTest(name = "sorts {0} → {1}")
    @MethodSource("unsortedPairs")
    @DisplayName("Parameterised: various arrays sorted correctly")
    void parameterisedSort(int[][] pair) {
        sorter.sort(pair[0]);
        assertArrayEquals(pair[1], pair[0]);
    }

    // -------------------------------------------------------------------------
    // 10. Immutability of length: sort must not change array length
    // -------------------------------------------------------------------------

    @Test
    @DisplayName("Sort does not alter the length of the array")
    void lengthUnchanged() {
        int[] arr = { 5, 3, 1, 4, 2 };
        int originalLength = arr.length;
        sorter.sort(arr);
        assertEquals(originalLength, arr.length);
    }

    // -------------------------------------------------------------------------
    // 11. In-place mutation: the same array reference must be modified
    // -------------------------------------------------------------------------

    @Test
    @DisplayName("Sort mutates the original array in-place")
    void sortsInPlace() {
        int[] arr = { 3, 1, 2 };
        int[] ref = arr;
        sorter.sort(arr);
        assertSame(ref, arr);
        assertArrayEquals(new int[] { 1, 2, 3 }, arr);
    }
}