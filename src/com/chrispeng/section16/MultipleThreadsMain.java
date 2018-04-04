package com.chrispeng.section16;


public class MultipleThreadsMain
{
    public static void main(String[] args) {
        Countdown countdown = new Countdown();
        CountThread t1 = new CountThread(countdown);
        t1.setName("Thread 1");
        CountThread t2 = new CountThread(countdown);
        t2.setName("Thread 2");

        t1.start();
        t2.start();
    }
}

class Countdown {
    private int i;
    void doCountdown() {
        String color;

        switch(Thread.currentThread().getName()) {
            case "Thread 1":
                color = ThreadColor.CYAN;
                break;
            case "Thread 2":
                color = ThreadColor.PURPLE;
                break;
            default:
                color = ThreadColor.GREEN;
        }

        synchronized ("Locked") {
            for (i = 10; i > 0; i--) {
                System.out.println(color + Thread.currentThread().getName() + ": i = " + i);
            }
        }
    }
}

class CountThread extends Thread {
    private Countdown threadCountdown;

    public CountThread(Countdown countdown) {
        threadCountdown = countdown;
    }

    @Override
    public void run()
    {
        threadCountdown.doCountdown();
    }
}
