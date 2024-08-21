package ThreadPoolExecuter;

import java.util.concurrent.*;

public class CallableExample {

    public static void main(String[] args) {

        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2, 4, 10,
                TimeUnit.MINUTES, new ArrayBlockingQueue<>(2), Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy());

        // new thread will create for task below
        // main thread will continue processing
        // inorder to know the status of the above executing thread, we can use FUTURE

        // here nothing returns, but we need the future object to know the status, complete etc..
        // ? means it doesn't know the return
        Future<?> futureObj = threadPoolExecutor.submit(() -> {
            try {
                Thread.sleep(7000); // 7 second delay
                System.out.println("task is processed by " + Thread.currentThread().getName());
            } catch (Exception e) {
                System.out.println(e);
            }
        });

        // main thread continue processing so the below statement returns false because of 7 seconds delay.
        System.out.println(futureObj.isDone()); // return false

        try {
            futureObj.get(2, TimeUnit.SECONDS); // which waits 2 seconds for timeout
        } catch (Exception e) {
            System.out.println(e); // timeout exception will occur
        }

        try {
            futureObj.get(); // waits till the thread finishes its execution or hold the main thread processing
        } catch (Exception e) {
            System.out.println(e);
        }

        System.out.println(futureObj.isDone()); // let know the status which is true


    }
}
