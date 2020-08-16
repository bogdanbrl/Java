package com.company;

public class Thread2 extends Thread {

    private int i=1;
    private boolean running=true;
    @Override
    public void run() {
        System.out.println("print from thread3");
        while(running){
            if(i==1){
                System.out.println("sunt treaz pentru prima data");
            }else{
                System.out.println("sunt treaz pentru a "+i+"-a oara");
            }
            try {
                Thread.sleep(3000);
                System.out.println("voi fi adomit pt 3 secunde. Astept sa fiu trezit");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            i++;
            if(i==11) {
                running=false;
                System.out.println("voi dormi mai mult");
            }
        }
    }
}
