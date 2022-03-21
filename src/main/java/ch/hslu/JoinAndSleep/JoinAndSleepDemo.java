package ch.hslu.JoinAndSleep;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class JoinAndSleepDemo {

    private static final Logger LOG = LogManager.getLogger(JoinAndSleepDemo.class);

    public static void main(String[] args) {
        JoinAndSleep joinAndSleep3 = new JoinAndSleep(() -> {
            LOG.info("joinAndSleep3 introduced");
            try {
                LOG.info("joinAndSleep3 sleeping for 4s");
                Thread.sleep(4000); // thread must sleep for 4 seconds
                LOG.info("joinAndSleep3 done sleeping");
            } catch (InterruptedException e) {
                LOG.info("joinAndSleep3 interrupted");
            }
        });

        JoinAndSleep joinAndSleep2 = new JoinAndSleep(() -> {
            LOG.info("joinAndSleep2 introduced");
            try {
                LOG.info("joinAndSleep2: join joinAndSleep3");
                joinAndSleep3.join();
                LOG.info("joinAndSleep2: done join joinAndSleep3");

                LOG.info("joinAndSleep2 sleeping for 3s");
                Thread.sleep(3000); // thread must sleep for 4 seconds
                LOG.info("joinAndSleep2 done sleeping");

            } catch (InterruptedException e) {
                LOG.info("joinAndSleep2 interrupted");
            }
        });

        JoinAndSleep joinAndSleep1 = new JoinAndSleep(() -> {
            LOG.info("joinAndSleep1 introduced");
            try {
                LOG.info("joinAndSleep1: join joinAndSleep2");
                joinAndSleep3.join();
                LOG.info("joinAndSleep1: done join joinAndSleep2");

                LOG.info("joinAndSleep1 sleeping for 2s");
                Thread.sleep(2000); // thread must sleep for 2 seconds
                LOG.info("joinAndSleep1 done sleeping");

            } catch (InterruptedException e) {
                LOG.info("joinAndSleep1 interrupted");
            }
        });

        joinAndSleep1.start();
        joinAndSleep2.start();
        joinAndSleep3.start();
    }
}
