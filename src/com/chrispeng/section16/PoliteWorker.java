package com.chrispeng.section16;

public class PoliteWorker
{
    public static void main(String[] args)
    {
        final Worker worker1 = new Worker("Worker 1", true);
        final Worker worker2 = new Worker("Worker 2", true);

        final SharedRecourse sharedRecourse = new SharedRecourse(worker1);
        new Thread(() -> worker1.work(sharedRecourse, worker2)).start();
        new Thread(() -> worker2.work(sharedRecourse, worker1)).start();
    }
}
