package com.chrispeng.section16;

public class Main
{

    public static void main(String[] args)
    {
        System.out.println("Hello from main thread");
        Thread anotherThread = new AnotherThread();
        anotherThread.setName("== Another thread ==");
        anotherThread.start();

        Thread myRunnable = new Thread(new MyRunnable());
        myRunnable.start();

        Thread myRunnable2 = new Thread(() -> {
            System.out.println("Hello from anonymous");
            try {
                anotherThread.join(2000);
                System.out.println("Anonymous terminated");
            } catch (InterruptedException e) {
                System.out.println("I couldn't wait after all. I was interrupted");
            }
        });
        myRunnable2.start();

        System.out.println("Hello again from main thread");
    }
}
