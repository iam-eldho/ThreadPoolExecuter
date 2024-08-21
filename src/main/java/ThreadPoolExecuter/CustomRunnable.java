package ThreadPoolExecuter;

import java.util.Arrays;
import java.util.List;

public class CustomRunnable implements Runnable {

    List<Integer> integerList;

    CustomRunnable(List<Integer> integerList) {
        this.integerList = integerList;
    }

    @Override
    public void run() {
        integerList.addAll(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
    }
}
