package ch.hslu.ad.Datenstrukturen.TimeComplexity;

public final class Task {

    private final int[] taskCounters = new int[3];

    public Task(final int n){
        task1(); task1(); task1(); task1(); // T ~ 4
        for (int i = 0; i < n; i++) { // äussere Schleife: n-mal
            task2(); task2(); task2(); // T ~ n · 3
            for (int j = 0; j < n; j++) { // innerer Schleife: n-mal
                task3(); task3(); // T ~ n · n· 2
            }
        }
    }

    public int[] getTaskCounters(){
        return taskCounters;
    }

    public void task1(){
        taskCounters[0]++;
    }
    public void task2(){
        taskCounters[1]++;
    }
    public void task3(){
        taskCounters[2]++;
    }
}
