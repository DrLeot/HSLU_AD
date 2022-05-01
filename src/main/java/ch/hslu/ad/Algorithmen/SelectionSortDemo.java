package ch.hslu.ad.Algorithmen;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Random;

public class SelectionSortDemo {

    private static final Logger LOG = LogManager.getLogger(SelectionSortDemo.class);

    public static void main(String[] args){
        circle(10_000);
        circle(20_000);
        circle(40_000);

    }

    private static void circle(final int n){
        int[] arraySorted = RandomArrays.getNumberedArray(n);
        int[] arrayReverseSorted = RandomArrays.getReverseNumberedArray(n);
        int[] arrayRandom = RandomArrays.getRandomNumberedUniqueArray(n);

        LOG.info("n -> {}", n);

        long startTime = System.currentTimeMillis();
        Sort.selectionSort(arraySorted);
        LOG.info("Sorted Array: {} ms",System.currentTimeMillis()-startTime);

        startTime = System.currentTimeMillis();
        Sort.selectionSort(arrayReverseSorted);
        LOG.info("Reserve Array: {} ms",System.currentTimeMillis()-startTime);

        startTime = System.currentTimeMillis();
        Sort.selectionSort(arrayRandom);
        LOG.info("Random Array: {} ms",System.currentTimeMillis()-startTime);

    }

}
