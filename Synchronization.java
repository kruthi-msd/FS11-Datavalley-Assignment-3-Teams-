//Synchronization
class Counter {
    private int count = 0;
    public synchronized void increment() {
        count++;
    }
    public int getCount() {
        return count;
    }
}

class IncrementerThread extends Thread {
    private Counter counter;
    private int times;

    public IncrementerThread(Counter counter, int times) {
        this.counter = counter;
        this.times = times;
    }

    public void run() {
        for (int i = 0; i < times; i++) {
            counter.increment();
        }
    }
}

public class Main{
    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();
        IncrementerThread thread1 = new IncrementerThread(counter, 1000);
        IncrementerThread thread2 = new IncrementerThread(counter, 1000);
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println("Final count: " + counter.getCount());
    }
}