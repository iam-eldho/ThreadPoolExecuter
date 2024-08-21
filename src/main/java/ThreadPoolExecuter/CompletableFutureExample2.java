package ThreadPoolExecuter;

import java.util.concurrent.*;

public class CompletableFutureExample2 {
    public static void main(String[] args) {

        try {
            //created thread pool executer
            ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2, 4, 10,
                    TimeUnit.MINUTES, new ArrayBlockingQueue<>(2), Executors.defaultThreadFactory(),
                    new ThreadPoolExecutor.AbortPolicy());

            // THEN COMPOSE

            CompletableFuture<String> asyncTask1 = CompletableFuture.supplyAsync(() -> {
                // task which need to be completed by thread
                System.out.println("supplyAsync thread is " + Thread.currentThread().getName());
                try {
                    Thread.sleep(5000);
                } catch (Exception e) {
                    System.out.println(e);
                }
                return "task completed";
            }, threadPoolExecutor);

            // Joining

            CompletableFuture<String> asyncTask2 = asyncTask1.thenCompose((String result) -> {
                return CompletableFuture.supplyAsync(() -> result + " by thenCompose");
            });

            // THEN COMPOSE ASYNC

            // Joining with thenComposeAsync

            CompletableFuture<String> asyncTask3 = asyncTask2.thenCompose((String result) -> {
                return CompletableFuture.supplyAsync(() -> result + " and by thenComposeAsync");
            });

            System.out.println(asyncTask3.get());


        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
