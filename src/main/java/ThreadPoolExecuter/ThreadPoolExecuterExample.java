package ThreadPoolExecuter;

import java.util.concurrent.*;

public class ThreadPoolExecuterExample {

    public static void main(String[] args) {

        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2, 4, 10,
                TimeUnit.MINUTES, new ArrayBlockingQueue<>(2), new CustomThreadFactory(),
                new Handler());
        threadPoolExecutor.allowCoreThreadTimeOut(true); // keepAliveTime only used when this set to true

        // 7 task will be ready to execute
        for (int i = 0; i < 7; i++) { // 7 tasks
            int finalI = i;
            // creating thread
            threadPoolExecutor.submit(() -> {
                try {
                    Thread.sleep(5000); // setting a delay
                } catch (Exception e) {
                    System.out.println(e);
                }
                System.out.println("task " + finalI + " processed by " + Thread.currentThread().getName());
            });
        }

        threadPoolExecutor.shutdown();

    }
}

class CustomThreadFactory implements ThreadFactory { // Custom thread factory for setting name, priority and daemon

    @Override
    public Thread newThread(Runnable r) {
        Thread thread = new Thread(r);
        thread.setPriority(1);
        thread.setDaemon(false);
        return thread;
    }
}

class Handler implements RejectedExecutionHandler { // Handle custom handler if rejection of task occurs

    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
        System.out.println("discarded");
    }
}
