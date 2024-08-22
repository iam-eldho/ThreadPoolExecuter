package Thread;

import java.util.concurrent.*;

public class ScheduledExecuterServiceExample {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(2);

        executorService.schedule(() -> {
            System.out.println("hello world");
        }, 5, TimeUnit.SECONDS); // after 5 seconds the process starts

        ScheduledExecutorService executorService1 = Executors.newScheduledThreadPool(2);

        Future<String> future = executorService1.schedule(() -> {
            System.out.println("hello world");
            return "hello world";
        }, 5, TimeUnit.SECONDS); // after 5 seconds the process starts

        System.out.println(future.get());

        ScheduledExecutorService executorService2 = Executors.newScheduledThreadPool(2);

        Future<?> future1 = executorService2.scheduleAtFixedRate(() -> {
            System.out.println("hello world");
        }, 5, 2, TimeUnit.SECONDS); // after 5 seconds the process starts and each 2 seconds its executes.

        try {
            Thread.sleep(10000);
        } catch (Exception e) {
            System.out.println(e);
        }
        future1.cancel(true);
    }
}
