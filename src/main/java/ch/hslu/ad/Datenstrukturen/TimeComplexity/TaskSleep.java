package ch.hslu.ad.Datenstrukturen.TimeComplexity;

public final class TaskSleep {

    private final long startTime;
    private final long endTime;

    public TaskSleep(final int n) throws InterruptedException{
        startTime = System.currentTimeMillis();
        task1(); task1(); task1(); task1(); // T ~ 4
        for (int i = 0; i < n; i++) { // äussere Schleife: n-mal
            task2(); task2(); task2(); // T ~ n · 3
            for (int j = 0; j < n; j++) { // innerer Schleife: n-mal
                task3(); task3(); // T ~ n · n· 2
            }
        }
        endTime = System.currentTimeMillis();
    }
    public long getStartTime() {
        return startTime;
    }
    public long getEndTime() {
        return endTime;
    }
    public long duration(){
        return endTime-startTime;
    }

    public void task1() throws InterruptedException {
        Thread.sleep(10);
    }
    public void task2() throws InterruptedException {
        Thread.sleep(10);
    }
    public void task3() throws InterruptedException {
        Thread.sleep(10);
    }


}
