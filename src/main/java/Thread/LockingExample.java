package Thread;

public class LockingExample {
    public static void main(String[] args) {

        // Shared Resource object
        SharedResource sharedResource = new SharedResource();


        // creating Thread 1
        Thread thread1 = new Thread(() -> {
            sharedResource.produce();
        });

        // creating Thread 2
        Thread thread2 = new Thread(() -> {
            sharedResource.produce();
        });

        thread1.start();
        thread2.start();
    }
}
