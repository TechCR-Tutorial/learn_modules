package com.cyclebarrier;

import java.util.Date;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Main thread wait till all sub threads come to one line.
 */
public class CycleBarrierSample {

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(4);
        CyclicBarrier barrier = new CyclicBarrier(3);
        executor.submit(new Task(barrier, 2000));
        executor.submit(new Task(barrier, 3000));
        executor.submit(new Task(barrier, 4000));

        System.out.println("Threade submited, main start wait");
        Thread.sleep(2000);
        System.out.println("Main thread completed. ");
    }

    public static class Task implements Runnable {

        private CyclicBarrier barrier;
        private int wait;

        public Task(CyclicBarrier barrier, int wait) {
            this.barrier = barrier;
            this.wait = wait;
        }

        @Override
        public void run() {
            while (true) {
                try {
                    System.out.println("Going to wait " + new Date());
                    Thread.sleep(wait);
                    barrier.await();
                    System.out.println("Wait done " + new Date());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
                System.out.println("Wait completed. ");
            }
            //send message to coresponding system.
        }
    }
}
