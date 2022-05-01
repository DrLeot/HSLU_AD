package ch.hslu.ad.Algorithmen;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public final class Sort {

    public static void bubbleSort(final int[] array){

        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {

                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    public static void selectionSort(final int[] array){
        for (int i = 0; i < array.length - 1; i++) {
            int index = i;

            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[index]){
                    index = j;
                }
            }

            int smallest = array[index];
            array[index] = array[i];
            array[i] = smallest;
        }
    }

    public static void insertionSort(final int[] array){
        int elt;
        int j;
        int[] tmpArray = new int[array.length + 1];

        System.arraycopy(array, 0, tmpArray, 1, array.length);

        for (int i = 2; i < tmpArray.length; i++) {
            elt = tmpArray[i];
            tmpArray[0] = elt;
            j = i;

            while (tmpArray[j - 1] > elt) {
                tmpArray[j] = tmpArray[j - 1];
                j--;
            }

            tmpArray[j] = elt;
        }

        System.arraycopy(tmpArray, 1, array, 0, array.length);
    }

    /**
     * Vertauscht zwei bestimmte Zeichen im Array.
     *
     * @param a Zeichen-Array
     * @param firstIndex Index des ersten Zeichens
     * @param secondIndex Index des zweiten Zeichens
     */
    private static void exchange(final char[] a,
                                       final int firstIndex,
                                       final int secondIndex) {
        char tmp;
        tmp = a[firstIndex];
        a[firstIndex] = a[secondIndex];
        a[secondIndex] = tmp;
    }
    private static void exchange(final int[] a,
                                 final int firstIndex,
                                 final int secondIndex) {
        int tmp;
        tmp = a[firstIndex];
        a[firstIndex] = a[secondIndex];
        a[secondIndex] = tmp;
    }

    public static void quickSort(final int[] a, final int left, final int right) {
        int up = left;
        int down = right - 1;
        int t = a[right];
        boolean allChecked = false;
        do {
            while (a[up] < t) {
                up++;
            }
            while ((a[down] >= t) && (down > up)) {
                down--;
            }
            if (down > up) {
                exchange(a, up, down);
                up++; down--;
            } else {
                allChecked = true;
            }
        } while (!allChecked);
        exchange(a, up, right);

        if (left < (up - 1)){
            quickSort(a, left, (up - 1));
        }
        if ((up + 1) < right){
            quickSort(a, (up + 1), right);
        }
    }

    public static void quickSort(final int[] a){
        quickSort(a,0,a.length-1);
    }

    public static void quickSort(final char[] a, final int left, final int right) {
        int up = left;
        int down = right - 1;
        char t = a[right];
        boolean allChecked = false;
        do {
            while (a[up] < t) {
                up++;
            }
            while ((a[down] >= t) && (down > up)) {
                down--;
            }
            if (down > up) {
                exchange(a, up, down);
                up++; down--;
            } else {
                allChecked = true;
            }
        } while (!allChecked);
        exchange(a, up, right);

        if (left <= (up - 1)){
            quickSort(a, left, (up - 1));
        }
        if ((up + 1) <= right){
            quickSort(a, (up + 1), right);
        }
    }

    public static void quickSort(final char[] a){
        quickSort(a,0,a.length-1);
    }

}
