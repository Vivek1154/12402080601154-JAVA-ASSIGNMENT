import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Program1 {

    
    public static boolean isPrime(int n) {
        if (n <= 1) return false;
        if (n == 2) return true;
        if (n % 2 == 0) return false;
        // Check odd numbers up to the square root of n
        for (int i = 3; i <= Math.sqrt(n); i += 2) {
            if (n % i == 0) return false;
        }
        return true;
    }

    
    static class PrimeThread extends Thread {
        private final int start, end;

        public PrimeThread(int start, int end, String name) {
            super(name);
            this.start = start;
            this.end = end;
        }

        @Override
        public void run() {
            for (int i = start; i <= end; i++) {
                if (isPrime(i)) {
                    System.out.println(Thread.currentThread().getName() + " found prime: " + i);
                }
            }
        }
    }

    
    static class PrimeRunnable implements Runnable {
        private final int start, end;

        public PrimeRunnable(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public void run() {
            for (int i = start; i <= end; i++) {
                if (isPrime(i)) {
                    System.out.println(Thread.currentThread().getName() + " found prime: " + i);
                }
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("=== 1. Using Thread Class ===");
       
        PrimeThread thread1 = new PrimeThread(2, 20, "ThreadClass-Worker");
        thread1.start();
        
        
        try { thread1.join(); } catch (InterruptedException e) { e.printStackTrace(); }

        System.out.println("\n=== 2. Using Runnable Interface ===");
       
        Thread thread2 = new Thread(new PrimeRunnable(21, 40), "Runnable-Worker");
        thread2.start();
        
        try { thread2.join(); } catch (InterruptedException e) { e.printStackTrace(); }

        System.out.println("\n=== 3. Using Executor Framework ===");
        
        ExecutorService executor = Executors.newFixedThreadPool(2);
        
        
        executor.submit(new Thread(new PrimeRunnable(41, 60), "Executor-Worker-1"));
        executor.submit(new Thread(new PrimeRunnable(61, 80), "Executor-Worker-2"));
        executor.submit(new Thread(new PrimeRunnable(81, 100), "Executor-Worker-3"));

        // Shut down the executor and wait for the submitted tasks to complete
        executor.shutdown();
        try {
            executor.awaitTermination(1, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            System.err.println("Executor tasks were interrupted.");
        }
        
        System.out.println("\nAll multithreading tasks completed successfully.");
    }
}
