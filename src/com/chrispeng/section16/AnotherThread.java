package com.chrispeng.section16;

public class AnotherThread extends Thread
{
    @Override
    public void run()
    {
        System.out.println("Hello from " + currentThread().getName());

        try {
            Thread.sleep(5000);
            System.out.println("Three seconds have passed and I'm awake.");
        } catch (InterruptedException e) {
            System.out.println("Another thread woke me up");
        }

    }
}
