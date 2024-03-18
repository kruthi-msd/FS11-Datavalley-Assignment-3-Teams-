Synchronization in Java is used to control access to shared resources by multiple threads to prevent data inconsistency. 
You can achieve synchronization using the synchronized keyword or by using synchronized blocks.
Steps:
    Choose the synchronization object: Decide which object to use for synchronization.
    Ensure consistency and safety: Make sure that all accesses to the shared resource are properly synchronized.
    Test thoroughly: Test your synchronized code with multiple threads to ensure that it behaves correctly under concurrent execution.
    Optimize performance: Consider the performance implications of synchronization and optimize your code if necessary.
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
