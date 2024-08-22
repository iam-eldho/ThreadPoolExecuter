package Thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ThreadMain {
    public static void main(String[] args) throws InterruptedException {
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

        ExecutorService executorService = Executors.newFixedThreadPool(2);

        executorService.submit(() -> {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
            System.out.println("task process completes");
        });

        executorService.shutdown(); // completes the already submitted process
        boolean isTerminated = executorService.awaitTermination(2, TimeUnit.SECONDS); // wait the main thread for 2 seconds and return the status.
        System.out.println(isTerminated);

    }
}
