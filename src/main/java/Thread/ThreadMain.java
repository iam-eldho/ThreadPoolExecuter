package Thread;

public class ThreadMain {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName() + " thread started");
        SharedResource sharedResource1 = new SharedResource();
        Thread thread1 = new Thread(() -> {
            sharedResource1.produce();
        });

        SharedResource sharedResource2 = new SharedResource();
        Thread thread2 = new Thread(() -> {
            sharedResource2.produce();
        });

        thread1.start(); // thread 1 starts execution
        thread2.start(); // thread 2 starts execution

    }
}
