package ch.hslu.ad.Datenstrukturen.TimeComplexity;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

public class TaskDemo {
    private static final Logger LOG = LogManager.getLogger(TaskDemo.class);

    public static void main(final String[] args){
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter Start n");
        int startn = scan.nextInt();
        System.out.println("Enter End n");
        int endn = scan.nextInt();

        System.out.println("N\tTask1\tTask2\tTask3");
        for(int i = startn; i <= endn; i++){
            Task task = new Task(i);
            System.out.println(i+"\t\t"+
                    task.getTaskCounters()[0]+"\t\t"+
                    task.getTaskCounters()[1]+"\t\t"+
                    task.getTaskCounters()[2]);

            /*LOG.debug("Task 1 wurde {} mal ausgeführt", task.getTaskCounters()[0]);
            LOG.debug("Task 2 wurde {} mal ausgeführt", task.getTaskCounters()[1]);
            LOG.debug("Task 3 wurde {} mal ausgeführt", task.getTaskCounters()[2]);*/
        }

    }
}
