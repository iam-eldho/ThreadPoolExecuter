package Thread;

import java.util.concurrent.locks.ReadWriteLock;

public class ReadWriteExample {

    boolean isAvailable = false;

    public void produce(ReadWriteLock lock) {
        try {
            lock.readLock().lock();
            isAvailable = true;
            System.out.println("lock acquired by " + Thread.currentThread().getName());
            Thread.sleep(8000);
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            lock.readLock().unlock();
            System.out.println("lock released by " + Thread.currentThread().getName());
        }
    }

    public void consume(ReadWriteLock lock) {
        try {
            lock.writeLock().lock();
            isAvailable = false;
            System.out.println("lock acquired by " + Thread.currentThread().getName());
            Thread.sleep(5000);
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            lock.writeLock().unlock();
            System.out.println("lock released by " + Thread.currentThread().getName());
        }
    }
}
