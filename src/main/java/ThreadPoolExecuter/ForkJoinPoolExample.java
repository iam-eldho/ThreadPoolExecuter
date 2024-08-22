package ThreadPoolExecuter;

import java.util.concurrent.RecursiveTask;

public class ForkJoinPoolExample extends RecursiveTask<Integer> {
    // The problem is to find the sum of n numbers, suppose 100, then the result would be like
    // 1 + 2 + 3 + ...100

    int start;
    int end;

    ForkJoinPoolExample(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Integer compute() {
        int total = 0;
        if (end - start <= 4) {
            for (int i = start; i <= end; i++) {
                total += i;
            }
        } else {
            int mid = (start + end) / 2;

            // Splitting the task to 2 sub task.
            ForkJoinPoolExample subTask1 = new ForkJoinPoolExample(start, mid);
            ForkJoinPoolExample subsTask2 = new ForkJoinPoolExample(mid + 1, end);

            // Fork the subtask's for parallel execution.
            subTask1.fork();
            subsTask2.fork();

            // Combine the result of two sub tasks.
            int subTask1Result = subTask1.join();
            int subTask2Result = subsTask2.join();

            //result
            total = subTask1Result + subTask2Result;
        }
        return total;
    }
}
