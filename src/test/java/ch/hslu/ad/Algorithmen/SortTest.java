package ch.hslu.ad.Algorithmen;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class SortTest {

    @Test
    public void testBubbleSortUsual(){
        int[] a = new int[]{13,5,9,6,121,18};
        Sort.bubbleSort(a);
        assertEquals("[5, 6, 9, 13, 18, 121]",Arrays.toString(a));
    }

    @Test
    public void testinsertionSort2Usual(){
        int[] a = new int[]{13,5,9,6,121,18};
        Sort.insertionSort(a);
        assertEquals("[5, 6, 9, 13, 18, 121]",Arrays.toString(a));
    }

    @Test
    public void testSelectionSortUsual(){
        int[] a = new int[]{13,5,9,6,121,18};
        Sort.selectionSort(a);
        assertEquals("[5, 6, 9, 13, 18, 121]",Arrays.toString(a));
    }
}