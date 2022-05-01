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
        final long start = System.currentTimeMillis();

        //final ExecutorService executorService = Executors.newCachedThreadPool();
        final ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors() + 1);
        List<Future<BigInteger>> results = new ArrayList<>();

        for(int i = 0; i < NUMBEROFPRIMES; i++){
            results.add(executorService.submit(new PrimeChecker()));
        }
        for (Future<BigInteger> result: results) {
            LOG.info(result.get().toString().substring(0, 20) + "...");
        }
        LOG.debug(System.currentTimeMillis() - start +" ms");
        LOG.debug("*** DONE ***");
    }
}
