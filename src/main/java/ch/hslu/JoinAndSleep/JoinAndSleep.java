package ch.hslu.JoinAndSleep;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class JoinAndSleep extends Thread{

    private static final Logger LOG = LogManager.getLogger(JoinAndSleep.class);

    public JoinAndSleep(Runnable runnable) {
        super(runnable);
        //LOG.debug("RUNNABLE");

    }
}
