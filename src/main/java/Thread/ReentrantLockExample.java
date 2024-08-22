package Thread;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockExample {

    public void produce(ReentrantLock lock) {
        try {
            lock.lock();
            System.out.println("lock acquired by " + Thread.currentThread().getName());
            Thread.sleep(5000);
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            lock.unlock();
            System.out.println("lock released by " + Thread.currentThread().getName());
        }
    }
}
