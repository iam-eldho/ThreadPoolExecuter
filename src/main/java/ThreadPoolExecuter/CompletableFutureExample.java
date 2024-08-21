package ThreadPoolExecuter;

import java.util.concurrent.*;

// Example for Completable Future
public class CompletableFutureExample {

    public static void main(String[] args) {

        try {
            //created thread pool executer
            ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2, 4, 10,
                    TimeUnit.MINUTES, new ArrayBlockingQueue<>(2), Executors.defaultThreadFactory(),
                    new ThreadPoolExecutor.AbortPolicy());

            // SUPPLY ASYNC

            CompletableFuture<String> asyncTask1 = CompletableFuture.supplyAsync(() -> {
                // task which need to be completed by thread
                return "task completed";
            }, threadPoolExecutor);

            System.out.println("result is " + asyncTask1.get());

            // THEN APPLY

            CompletableFuture<String> asyncTask2 = CompletableFuture.supplyAsync(() -> {
                // task which need to be completed by thread
                System.out.println("supplyAsync thread is " + Thread.currentThread().getName());
                try {
                    Thread.sleep(5000);
                } catch (Exception e) {
                    System.out.println(e);
                }
                return "task completed";
            }, threadPoolExecutor).thenApply((String result) -> {
                System.out.println("thenApply thread is " + Thread.currentThread().getName());
                return result + " and from thenApply";
            });

            System.out.println("result is " + asyncTask2.get());


            // THEN APPLY ASYNC

            CompletableFuture<String> asyncTask3 = CompletableFuture.supplyAsync(() -> {
                // task which need to be completed by thread
                System.out.println("supplyAsync thread is " + Thread.currentThread().getName());
                try {
                    Thread.sleep(5000);
                } catch (Exception e) {
                    System.out.println(e);
                }
                return "task completed";
            }, threadPoolExecutor);

            asyncTask3.thenApplyAsync((String result) -> {
                System.out.println("supplyAsync thread is " + Thread.currentThread().getName());
                return result + "from thenApplyAsync";
            });

            System.out.println(asyncTask3.get());


        } catch (Exception e) {
            System.out.println(e);
        }


    }
}
