package ThreadPoolExecuter;

import java.util.concurrent.*;

public class CallableExample2 {

    public static void main(String[] args) {

        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2, 4, 10,
                TimeUnit.MINUTES, new ArrayBlockingQueue<>(2), Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy());

        // Callable , which returns an integer value from the thread
        Future<Integer> future = threadPoolExecutor.submit(() -> {
            System.out.println("task processed by " + Thread.currentThread().getName());
            return 10;
        });

        try {
            System.out.println("result " + future.get());
        } catch (Exception e) {
            System.out.println(e);
        }

    }
}
