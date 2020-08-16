package com.company;



public class Thread0 extends java.lang.Thread {



    @Override
    public void run() {
        System.out.println("print from thread1");
        for(int i=1; i<=10; i++){
            System.out.println(currentThread().getName()+" a ajuns la nr "+i);
            try{Thread.sleep(1000);}catch (InterruptedException e){e.getMessage();}
        }
    }
}
