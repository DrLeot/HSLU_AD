package ch.hslu.ad.ThreadAbortion;

import java.util.ArrayList;
import java.util.List;

public class AdditionTaskDemo {

    public static void main(String[] args) throws InterruptedException {
        ArrayList<AdditionTask> additionTasks = new ArrayList<>();
        ArrayList<Thread> threads = new ArrayList<>();

        for (int i = 1; i <= 10; i++) {
            AdditionTask task = new AdditionTask(i * 10, i * 100);
            additionTasks.add(task);
            threads.add(new Thread(task, "Task " + i));
        }

        threads.forEach(Thread::start);

        Thread.sleep(500);

        //additionTasks.forEach(AdditionTask::stopGoodExample);
        additionTasks.forEach(AdditionTask::stopBadExample);
    }
}
