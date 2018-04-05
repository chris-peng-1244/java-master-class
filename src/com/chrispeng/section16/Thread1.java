package com.chrispeng.section16;

import static com.chrispeng.section16.ThreadColor.BLUE;
import static com.chrispeng.section16.ThreadColor.GREEN;
import static com.chrispeng.section16.ThreadColor.RED;

public class Thread1 {
    public static void main(String[] args) {
        System.out.println(BLUE + "Hello from main thread");
        Thread anotherThread = new AnotherThread();
        anotherThread.start();

        new Thread(() -> System.out.println(GREEN + "Hello from anonymous thread")).start();

        System.out.println(RED + "Hello again from the main thread");
    }
}
