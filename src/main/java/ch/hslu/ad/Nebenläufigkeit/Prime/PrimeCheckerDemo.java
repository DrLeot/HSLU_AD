package ch.hslu.ad.Nebenläufigkeit.Prime;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class PrimeCheckerDemo {

    public static final int NUMBEROFPRIMES = 100;
    private static final Logger LOG = LogManager.getLogger(PrimeCheckerDemo.class);

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        final ExecutorService executorService = Executors.newCachedThreadPool();
        List<Future<BigInteger>> results = new ArrayList<>();

        final long start = System.currentTimeMillis();
        for(int i = 0; i < NUMBEROFPRIMES; i++){
            results.add(executorService.submit(new PrimeChecker()));
        }
        for (Future<BigInteger> result: results) {
            LOG.debug(result.get());
        }
        LOG.debug(System.currentTimeMillis() - start +" ms");
        LOG.debug("*** DONE ***");
    }
}
