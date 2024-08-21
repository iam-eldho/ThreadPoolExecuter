package ThreadPoolExecuter;

import java.util.concurrent.*;

public class CompletableFutureExample4 {
    public static void main(String[] args) {
        try {
            //created thread pool executer
            ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2, 4, 10,
                    TimeUnit.MINUTES, new ArrayBlockingQueue<>(2), Executors.defaultThreadFactory(),
                    new ThreadPoolExecutor.AbortPolicy());

            // Then Combine

            CompletableFuture<String> asyncTask1 = CompletableFuture.supplyAsync(() -> {
                return "Hello World ";
            }, threadPoolExecutor);

            CompletableFuture<Integer> asyncTask2 = CompletableFuture.supplyAsync(() -> {
                return 10;
            }, threadPoolExecutor);

            CompletableFuture<String> combinedResult = asyncTask1.thenCombine(asyncTask2, (String str, Integer num) -> {
                return str + num;
            });

            CompletableFuture<String> combinedResult2 = asyncTask1.thenCombineAsync(asyncTask2, (String str, Integer num) -> {
                return str + num;
            });

            System.out.println(combinedResult.get());

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
