package ch.hslu.ad.Fibonacci;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class FibonacciDemo {
    private static final Logger LOG = LogManager.getLogger(FibonacciDemo.class);

    public static void main( String[] args ) {
        long starttime;
        long endtime;
        long difference;

        starttime = System.currentTimeMillis();
        Fibonacci.fiboRec1(8);
        endtime = System.currentTimeMillis();
        difference = endtime - starttime;
        LOG.debug(difference);

        starttime = System.currentTimeMillis();
        Fibonacci.fiboRec2(8);
        endtime = System.currentTimeMillis();
        difference = endtime - starttime;
        LOG.debug(difference);

        starttime = System.currentTimeMillis();
        Fibonacci.fiboIter(8);
        endtime = System.currentTimeMillis();
        difference = endtime - starttime;
        LOG.debug(difference);

    }
}
