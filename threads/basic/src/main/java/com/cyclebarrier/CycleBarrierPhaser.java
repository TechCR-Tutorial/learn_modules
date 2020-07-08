package com.cyclebarrier;

import java.util.Date;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Phaser;

/**
 * Main thread wait till all sub threads come to one line.
 */
public class CycleBarrierPhaser {

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(4);
        Phaser phaser = new Phaser(3);
        executor.submit(new Task(phaser, 2000));
        executor.submit(new Task(phaser, 3000));
        executor.submit(new Task(phaser, 5000));

        System.out.println("Threade submited, main start wait");
        executor.shutdown();
        System.out.println("Main thread completed. ");
    }

    public static class Task implements Runnable {

        private Phaser phaser;
        private int wait;

        public Task(Phaser phaser, int wait) {
            this.phaser = phaser;
            this.wait = wait;
        }

        @Override
        public void run() {
//            while (true) {
                try {
//                    phaser.register();
//                    phaser.bulkRegister(2);
//                    phaser.arriveAndDeregister();
                    System.out.println("Going to wait " + new Date());
                    Thread.sleep(wait);
                    phaser.arriveAndAwaitAdvance();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Wait completed. " + new Date());
//            }
            //send message to coresponding system.
        }
    }
}
