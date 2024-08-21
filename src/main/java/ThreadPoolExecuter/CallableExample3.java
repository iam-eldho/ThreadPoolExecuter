package ThreadPoolExecuter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class CallableExample3 {

    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2, 4, 10,
                TimeUnit.MINUTES, new ArrayBlockingQueue<>(2), Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy());

        List<Integer> integerList = new ArrayList<>();
        // object reference is passed to the runnable
        Future<List<Integer>> future = threadPoolExecutor.submit(new CustomRunnable(integerList), integerList);

        try {
            future.get(); // waits till it finishes the process
            future.get().forEach(System.out::println); // returns the result
            integerList.forEach(System.out::println);
        } catch (Exception e) {
            System.out.println(e);
        }

        // use case 2
        // callable example, more clean way
        Future<List<Integer>> future1 = threadPoolExecutor.submit(() -> {
            List<Integer> integerList1 = new ArrayList<>();
            integerList1.add(1);
            return integerList1;
        });

        try {
            future1.get().forEach(System.out::println);
        } catch (Exception e) {
            System.out.println(e);
        }

    }
}
