package com.countdownlatch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * CountdownLatch for wait main thread to initialize number of threads.
 */
public class CountDownLatchSample {

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(4);

        CountDownLatch latch = new CountDownLatch(3);
        executor.submit(new DependantService(latch, "1",2000));
        executor.submit(new DependantService(latch, "2",5000));
        executor.submit(new DependantService(latch, "3",3000));
        System.out.println("Waiting Main thread");
        System.out.println("Count " + latch.getCount());
        latch.await();
        System.out.println("All dependee service intialized. ");
        System.out.println("Count " + latch.getCount());
        executor.shutdown();
    }

    public static class DependantService implements Runnable {

        private CountDownLatch latch;
        private int wait;
        private String name;

        public DependantService(CountDownLatch latch, String name, int wait) {
            this.latch = latch;
            this.name = name;
            this.wait = wait;
        }

        @Override
        public void run() {
            //Start task
            try {
                System.out.println("Goint to countdown- " + name);
                Thread.sleep(wait);
                latch.countDown();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Child done- " + name);
            //Continue other operations.
        }
    }
}

