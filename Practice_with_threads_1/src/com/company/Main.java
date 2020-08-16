package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.println("\n");

        java.lang.Thread thread_0 = new Thread0();
        thread_0.start();
        java.lang.Thread thread_00 = new Thread0();
        thread_00.start();


        java.lang.Thread thread_1 = new Thread1();
        thread_1.start();

        java.lang.Thread thread_2 = new Thread2();
        thread_2.start();

        java.lang.Thread thread_3 = new Thread3();
        thread_3.start();

        Thread myRrr = new Thread(new myRunnable());
        myRrr.start();

        Thread myRrr1 = new Thread(new myRunnable(){
            @Override
            public void run() {
                System.out.println("salut de la myRrr1");
            }
        });
        myRrr1.start();
    }
}
