package com.bogdanbrl;

public class Main {

    public static Object lock1 = new Object();
    public static Object lock2 = new Object();
    public static Object lock3 = new Object();
    public static Object lock4 = new Object();

    public static void main(String[] args) {


        new Thread1().start();
        new Thread2().start();
        new Thread3().start();
        new Thread4().start();
    }

    private static class Thread1 extends Thread {
        public void run() {
            synchronized (lock1) {
                System.out.println("Thread 1: Has lock1");
                try {
                    Thread.sleep(100);
                } catch(InterruptedException e) {

                }
                System.out.println("Thread 1: Waiting for lock2");
                synchronized (lock2) {
                    System.out.println("Thread 1: Has lock1 and lock2");
                }
                System.out.println("Thread 1: Released lock2");
            }
            System.out.println("Thread 1: Released lock1. Exiting...");
        }
    }

    private static class Thread2 extends Thread {
        public void run() {
            synchronized (lock2) {
                System.out.println("Thread 2: Has lock2");
                try {
                    Thread.sleep(100);
                } catch(InterruptedException e) {

                }
                System.out.println("Thread 2: Waiting for lock3");
                synchronized (lock3) {
                    System.out.println("Thread 2: Has lock2 and lock3");
                }
                System.out.println("Thread 2: released lock3");
            }
            System.out.println("Thread 2: Released lock2. Exiting...");
        }
    }

    private static class Thread3 extends Thread {
        public void run() {
            synchronized (lock3) {
                System.out.println("Thread 3: Has lock3");
                try {
                    Thread.sleep(100);
                } catch(InterruptedException e) {

                }
                System.out.println("Thread 3: Waiting for lock4");
                synchronized (lock4) {
                    System.out.println("Thread 3: Has lock3 and lock4");
                }
                System.out.println("Thread 3: released lock4");
            }
            System.out.println("Thread 3: Released lock3. Exiting...");
        }
    }

    private static class Thread4 extends Thread {
        public void run() {
            synchronized (lock1) {
                System.out.println("Thread 4: Has lock4");
                try {
                    Thread.sleep(100);
                } catch(InterruptedException e) {

                }
                System.out.println("Thread 4: Waiting for lock1");
                synchronized (lock4) {
                    System.out.println("Thread 4: Has lock4 and lock1");
                }
                System.out.println("Thread 4: released lock1");
            }
            System.out.println("Thread 4: Released lock4. Exiting...");
        }
    }
}







