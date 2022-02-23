package ch.hslu.ad.TimeComplexity;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

public class TaskSleepDemo {
    private static final Logger LOG = LogManager.getLogger(TaskSleepDemo.class);

    public static void main(final String[] args){
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter Start n");
        int startn = scan.nextInt();
        System.out.println("Enter End n");
        int endn = scan.nextInt();

        for(int i = startn; i <= endn; i++){
            TaskSleep taskSleep = null;
            try {
                taskSleep = new TaskSleep(i);
            } catch (InterruptedException e) {
                e.printStackTrace();
                return;
            }
            System.out.println(taskSleep.getStartTime()+"\t"+
                    taskSleep.getEndTime()+"\t"+
                    taskSleep.duration());

            /*LOG.debug("Task 1 wurde {} mal ausgeführt", task.getTaskCounters()[0]);
            LOG.debug("Task 2 wurde {} mal ausgeführt", task.getTaskCounters()[1]);
            LOG.debug("Task 3 wurde {} mal ausgeführt", task.getTaskCounters()[2]);*/
        }

    }
}
