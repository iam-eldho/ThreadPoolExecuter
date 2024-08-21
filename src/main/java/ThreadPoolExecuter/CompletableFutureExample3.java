package ThreadPoolExecuter;

import java.util.concurrent.*;

public class CompletableFutureExample3 {

    public static void main(String[] args) {

        try {
            //created thread pool executer
            ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2, 4, 10,
                    TimeUnit.MINUTES, new ArrayBlockingQueue<>(2), Executors.defaultThreadFactory(),
                    new ThreadPoolExecutor.AbortPolicy());

            // THEN ACCEPT

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

            // thenAccept
            asyncTask1.thenAccept((String result) -> System.out.println("end of operation " + result));

            // thenAcceptAsync
            asyncTask1.thenAcceptAsync((String result) -> System.out.println("final end " + result));

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
