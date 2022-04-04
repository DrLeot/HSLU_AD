package ch.hslu.ad.Nebenläufigkeit.Prime;

import java.math.BigInteger;
import java.util.Random;
import java.util.concurrent.Callable;

public class PrimeChecker implements Callable<BigInteger> {

    public static final int NUMBEROFBITS = 1024;
    private BigInteger candidate;

    private static BigInteger newRandomNumber(){
        return new BigInteger(NUMBEROFBITS, new Random());
    }

    public PrimeChecker(){
        this.candidate = PrimeChecker.newRandomNumber();
    }

    @Override
    public BigInteger call() throws Exception {
        while (!candidate.isProbablePrime(Integer.MAX_VALUE)){
            candidate = PrimeChecker.newRandomNumber();
        }
        return candidate;
    }
}
