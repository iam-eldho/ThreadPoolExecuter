package Thread;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class LockExample {
    public static void main(String[] args) {
        // lock object is created
        ReentrantLock lock = new ReentrantLock();

        ReadWriteLock lock1 = new ReentrantReadWriteLock();

        ReadWriteExample resource1 = new ReadWriteExample();

        Thread thread1 = new Thread(() -> {
            resource1.produce(lock1);
        });

        Thread thread2 = new Thread(() -> {
            resource1.produce(lock1);
        });

        ReadWriteExample resource2 = new ReadWriteExample();
        Thread thread3 = new Thread(() -> {
            resource2.consume(lock1);
        });

        thread1.start();
        thread2.start();
        thread3.start();

    }
}
