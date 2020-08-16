package com.company;

public class Thread3 extends Thread {


    @Override
    public void run() {
        System.out.println("print from thread4");
        super.run();
        System.out.println(currentThread().getName()+" doarme si asteapta sa fie trezit peste 3 secunde");
        try {
            Thread0.sleep(3000);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(currentThread().getName()+" s-a trezit");
    }
}
