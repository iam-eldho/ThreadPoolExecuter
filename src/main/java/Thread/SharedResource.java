package Thread;

public class SharedResource {
    boolean isAvailable = false;

    public synchronized void produce() {
        System.out.println("lock acquired by " + Thread.currentThread().getName() + " thread");
        isAvailable = true;
        try {
            Thread.sleep(10000);
        } catch (Exception e) {
            System.out.println(e);
        }
        System.out.println("lock released by " + Thread.currentThread().getName() + " thread");
    }
}