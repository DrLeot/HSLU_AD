package ch.hslu.ad.Algorithmen;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public final class Sort {


    public static int getRandomInt(final int min, final int max) {
        Random random = new Random();

        return random.nextInt((max - min) + 1) + min;
    }
    public static int[] getRandomNumberedUniqueArray(final int n){
        ArrayList<Integer> numbers = new ArrayList<>();

        while (numbers.size() < n) {
            int random = getRandomInt(1, n);

            if (!numbers.contains(random)) {
                numbers.add(random);
            }
        }

        return numbers.stream().mapToInt(i -> i).toArray();
    }

    public static int[] getReverseNumberedArray(final int n){
        int[] ret = new int[n];
        for(int i = n; i > 0; i--){
            ret[n-i] = i;
        }
        return ret;
    }
    public static int[] getNumberedArray(final int n){
        int[] ret = new int[n];
        for(int i = 0; i < n; i++){
            ret[i] = i+1;
        }
        return ret;
    }

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
}
