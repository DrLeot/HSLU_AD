package ch.hslu.ad.Nebenläufigkeit.ThreadAbortion;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class AdditionTask implements Runnable{

    private static final Logger LOG = LogManager.getLogger(AdditionTask.class);

    private Thread runThread;
    private boolean isStopped = false;
    private final int rangeBegin;
    private final int rangeEnd;

    public AdditionTask(int rangeBegin, int rangeEnd){
        this.rangeBegin = rangeBegin;
        this.rangeEnd = rangeEnd;
    }

    public void stopGoodExample(){
        this.isStopped = true;
        this.runThread.interrupt();
    }

    public void stopBadExample(){
        this.isStopped = true;
        this.runThread.stop(); //dep. since 1.2!
    }

    @Override
    public void run() {
        this.runThread = Thread.currentThread();
        // Initialisierungsphase
        long sum = 0;
        // Arbeitsphase
        for (int i = this.rangeBegin; i <= this.rangeEnd; i++) {
            sum += i;

            try {
                Thread.sleep(15);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
        // Abschlussphase
        if (!isStopped()) {
            LOG.info(runThread.getName() + ": SUM " + sum);
        }
        else {
            LOG.info(runThread.getName() + ": interrupted.");
        }
    }


    public boolean isStopped(){
        return isStopped;
    }
}
