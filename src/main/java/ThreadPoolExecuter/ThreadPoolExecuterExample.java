package ThreadPoolExecuter;

import java.util.concurrent.*;

public class ThreadPoolExecuterExample {

    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2, 4, 10,
                TimeUnit.MINUTES, new ArrayBlockingQueue<>(2), new CustomThreadFactory(),
                new Handler());

        for (int i = 0; i < 7; i++) {
            int finalI = i;
            threadPoolExecutor.submit(() -> {
                try {
                    Thread.sleep(5000);
                } catch (Exception e) {
                    System.out.println(e);
                }
                System.out.println("task " + finalI + " processed by " + Thread.currentThread().getName());
            });
        }

        threadPoolExecutor.shutdown();

    }
}

class CustomThreadFactory implements ThreadFactory {

    @Override
    public Thread newThread(Runnable r) {
        Thread thread = new Thread(r);
        thread.setPriority(1);
        thread.setDaemon(false);
        return thread;
    }
}

class Handler implements RejectedExecutionHandler {

    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
        System.out.println("discarded");
    }
}
