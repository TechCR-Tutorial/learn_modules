package com.countdownlatch;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Phaser;

/**
 * CountdownLatch for wait main thread to initialize number of threads.
 */
public class CountDownLatchPhaser {

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(4);

        Phaser phaser = new Phaser(3);
        executor.submit(new DependantService(phaser, 2000));
        executor.submit(new DependantService(phaser, 3000));
        executor.submit(new DependantService(phaser, 4000));
        System.out.println("Waiting Main thread");
        phaser.awaitAdvance(1);
        System.out.println("All dependee service intialized. ");
    }

    public static class DependantService implements Runnable {

        private Phaser phaser;
        private int wait;

        public DependantService(Phaser phaser, int wait) {
            this.phaser = phaser;
            this.wait = wait;
        }

        @Override
        public void run() {
            //Start task
            try {
                System.out.println("Goint to countdown. ");
                Thread.sleep(wait);
                phaser.arrive();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Child done");
            //Continue other operations.
        }
    }
}

