package com.chrispeng.section16;

public class AnotherThread extends Thread {
    @Override
    public void run() {
        System.out.println(ThreadColor.PURPLE + "Hello from another thread.");
    }
}
