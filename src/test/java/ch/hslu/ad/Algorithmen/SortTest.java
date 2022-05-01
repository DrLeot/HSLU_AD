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

    @Test
    public void testQuickSortRecursive(){
        char[] arr = new char[]{'b','x','f','e','g','h'};
        Sort.quickSort(arr,0,arr.length-1);
        assertEquals("[b, e, f, g, h, x]",Arrays.toString(arr));
    }

    @Test
    public void testQuickSort(){
        char[] arr = new char[]{'e','d','c','b','a','f'};
        Sort.quickSort(arr);
        assertEquals("[a, b, c, d, e, f]",Arrays.toString(arr));
    }

    @Test
    public void testQuickSortInteger(){
        int[] arr = new int[]{15,19,2,8,7,5};
        Sort.quickSort(arr);
        assertEquals("[2, 5, 7, 8, 15, 19]",Arrays.toString(arr));
    }
}