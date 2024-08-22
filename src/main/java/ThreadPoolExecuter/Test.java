package ThreadPoolExecuter;

import java.util.concurrent.*;

public class Test {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.submit(() -> System.out.println("task"));

        ExecutorService executorService2 = Executors.newCachedThreadPool();
        executorService2.submit(() -> System.out.println("task 2"));

        ExecutorService executorService3 = Executors.newSingleThreadExecutor();
        executorService3.submit(() -> System.out.println("task 3"));

        ForkJoinPool pool = ForkJoinPool.commonPool();
        Future<Integer> result = pool.submit(new ForkJoinPoolExample(0, 100));
        System.out.println("sum is " + result.get());
    }
}

