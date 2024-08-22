package Thread;

import java.util.concurrent.locks.ReentrantLock;

public class LockExample {
    public static void main(String[] args) {
        // lock object is created
        ReentrantLock lock = new ReentrantLock();
        ReentrantLockExample resource1 = new ReentrantLockExample();

        Thread thread1 = new Thread(() -> {
            resource1.produce(lock);
        });

        ReentrantLockExample resource2 = new ReentrantLockExample();
        Thread thread2 = new Thread(() -> {
            resource2.produce(lock);
        });


        thread1.start();
        thread2.start();

    }
}
