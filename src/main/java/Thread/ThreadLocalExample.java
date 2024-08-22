package Thread;

public class ThreadLocalExample {
    public static void main(String[] args) {
        ThreadLocal<String> threadMain = new ThreadLocal<>();

        threadMain.set(Thread.currentThread().getName());

        Thread thread1 = new Thread(() -> {
            System.out.println("running thread 1");
            threadMain.set(Thread.currentThread().getName());
        });

        Thread thread2 = new Thread(() -> {
            System.out.println("running thread 2");
            threadMain.set(Thread.currentThread().getName());

            threadMain.remove(); // clean it
        });

        thread1.start();
        thread2.start();


        System.out.println(threadMain.get());


    }
}
