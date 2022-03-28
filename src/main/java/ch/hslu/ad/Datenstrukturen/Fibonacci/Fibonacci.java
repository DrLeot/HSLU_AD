package ch.hslu.ad.Datenstrukturen.Fibonacci;

import java.util.HashMap;
import java.util.Map;

public final class Fibonacci {

    private static final Map<Integer, Integer> fibonacciItems = new HashMap<>();

    public static Map<Integer, Integer> getFibonacciItems(){
        return fibonacciItems;
    }

    public static int fiboRec1(final int n){
        // Rekursionsbasis
        if (n <= 0){
            return 0;
        }
        if(n == 1){
            return 1;
        }
        sleep();

        // Rekursionsschrift
        return fiboRec1(n-1) + fiboRec1(n-2);
    }

    public static int fiboRec2(final int n){
        // Rekursionsbasis
        if (n <= 0){
            return 0;
        }
        if(n == 1){
            return 1;
        }
        sleep();
        if (fibonacciItems.containsKey(n)) {
            return fibonacciItems.get(n);
        }

        // Rekursionsschrift
        int nextFibonacciNumber = fiboRec2(n-1) + fiboRec2(n-2);
        fibonacciItems.put(n, nextFibonacciNumber);
        return nextFibonacciNumber;
    }

    public static int fiboIter(final int n){
        if (n < 0){
            return 0;
        }

        int tmp;
        int previousFibonacci = 0;
        int currentFibonacci = 1;

        for(int i = 0; i < n; i++){
            sleep();

            tmp = previousFibonacci;
            previousFibonacci = currentFibonacci;
            currentFibonacci += tmp;
        }
        return previousFibonacci;
    }

    private static void sleep(){
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
