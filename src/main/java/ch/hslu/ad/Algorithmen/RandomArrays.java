package ch.hslu.ad.Algorithmen;

import java.util.ArrayList;
import java.util.Random;

public final class RandomArrays {

    public static char[] randomChars(final int length){
        char[] ret = new char[length];

        for(int i = 0; i < ret.length; i++){
            ret[i] = getRandomLowerCaseChar();
        }
        return ret;
    }

    private static char getRandomLowerCaseChar(){
        return (char) getRandomInt(65,90); // ASCII Code for A-Z
    }
    private static int getRandomInt(final int min, final int max) {
        Random random = new Random();

        return random.nextInt((max - min) + 1) + min;
    }
    public static int[] getRandomNumberedArray(final int n){
        int[] ret = new int[n];

        for(int i = 0; i < n;i++){
            ret[i] = getRandomInt(0, Integer.MAX_VALUE-1);
        }
        return ret;
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

}
