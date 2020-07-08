package com.threadlocal;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Supplier;

/**
 * Thread local for manage status between threads.
 * Manage same values for same thread.
 */
public class UserService {

    private Supplier<SimpleDateFormat> dateFormatSupplier;
    private Supplier<String> threadNameSupplier;

    public UserService(Supplier<SimpleDateFormat> dateFormatSupplier, Supplier<String> threadNameSupplier) {
        this.dateFormatSupplier = dateFormatSupplier;
        this.threadNameSupplier = threadNameSupplier;
    }

    public void printUser(User user) {
        System.out.println("Current: " + Thread.currentThread().getName() +
                " +++ From Supplier: " + threadNameSupplier.get() + " +++ Name: "
                + user.getName() + " - BirthDate: " + dateFormatSupplier.get().format(user.getBirthDate()));
    }


    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(4);
        ThreadLocal<String> stringThreadLocal = ThreadLocal.withInitial(() -> Thread.currentThread().getName());
        for (int i = 0; i < 25; i++) {
            User user = new User("User " + i, new Date());
            executor.submit(() ->
                    new UserService(() -> new LocalThreadLocal().get(), () -> stringThreadLocal.get()).printUser(user));
        }
        executor.shutdown();
    }

}
