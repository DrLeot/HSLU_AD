package ch.hslu.ad.Algorithmen;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class QuickSortDemo {

    private static final Logger LOG = LogManager.getLogger(insertionSortDemo.class);

    public static void main(String[] args){
        LOG.info("Chars");
        circle(100_000);
        circle(200_000);
        circle(400_000);


        LOG.info("Ints");
        circleInt(10_000);
        circleInt(20_000);
        circleInt(40_000);

    }

    private static void circleInt(final int n){
        int[] randomIntArray = RandomArrays.getRandomNumberedArray(n);

        LOG.info("n -> {}", n);

        long startTime = System.currentTimeMillis();
        Sort.quickSort(randomIntArray);
        LOG.info("Random Char Array: {} ms",System.currentTimeMillis()-startTime);

    }
    private static void circle(final int n) {
        char[] randomCharArray = RandomArrays.randomChars(n);

        LOG.info("n -> {}", n);

        long startTime = System.currentTimeMillis();
        Sort.quickSort(randomCharArray);
        LOG.info("Random Char Array: {} ms",System.currentTimeMillis()-startTime);

    }
}
