package com.bogdanbrl;

public class Main {

    public static void main(String[] args) {
        final PolitePerson jane1 = new PolitePerson("Jane");
        final PolitePerson john1 = new PolitePerson("John");

        new Thread(() -> jane1.sayHello(john1)).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                john1.sayHello(jane1);
            }
        }).start();
    }

    // 1. Thread1 acquires the lock on the jane object and enters the sayHello() method.
    // It prints to the console, then suspends.
    // 2. Thread2 acquires the lock on the john object and enters the sayHello() method.
    // It prints to the console, then suspends.
    // 3. Thread1 runs again and wants to say hello back to the john object. It tries to call the sayHelloBack() method
    // using the john object that was passed into the sayHello() method,
    // but Thread2 is holding the john lock, so Thread1 suspends.
    // 4. Thread2 runs again and wants to say hello back to the jane object. It tries to call the sayHelloBack() method
    // using the jane object that was passed into the sayHello() method,
    // but Thread1 is holding the jane lock, so Thread2 suspends.

    static class PolitePerson {
        private final String name;

        PolitePerson(String name) {
            this.name = name;
        }

        String getName() {
            return name;
        }

        synchronized void sayHello(PolitePerson person) {
            System.out.format("%s: %s" + " has said hello to me!%n", this.name, person.getName());
            person.sayHelloBack(this);
        }

        synchronized void sayHelloBack(PolitePerson person) {
            System.out.format("%s: %s" + " has said hello back to me!%n", this.name, person.getName());
        }
    }
}
