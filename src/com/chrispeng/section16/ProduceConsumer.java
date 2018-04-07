package com.chrispeng.section16;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;
import java.util.concurrent.locks.ReentrantLock;

import static com.chrispeng.section16.ProduceConsumer.EOF;

public class ProduceConsumer {
    public static final String EOF = "EOF";

    public static void main(String[] args) {
        ArrayBlockingQueue<String> buffer = new ArrayBlockingQueue<>(6);
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        Producer producer = new Producer(buffer, ThreadColor.YELLOW);
        MyConsumer consumer1 = new MyConsumer(buffer, ThreadColor.PURPLE);
        MyConsumer consumer2 = new MyConsumer(buffer, ThreadColor.CYAN);
//        new Thread(producer).start();
//        new Thread(consumer1).start();
//        new Thread(consumer2).start();
        executorService.execute(producer);
        executorService.execute(consumer1);
        executorService.execute(consumer2);

        Future<String> future = executorService.submit(() -> {
            System.out.println(ThreadColor.WHITE + "I'm being printed for the Callable class");
            return "This is the callable result";
        });

        try {
            System.out.println(future.get());
        } catch (ExecutionException e) {
            System.out.println("Something went wrong");
        } catch (InterruptedException e) {
            System.out.println("Thread running the task was interrupted.");
        }

        executorService.shutdown();
    }
}

class Producer implements Runnable {

    private ArrayBlockingQueue<String> buffer;
    private String color;

    public Producer(ArrayBlockingQueue<String> buffer, String color) {
        this.buffer = buffer;
        this.color = color;
    }

    @Override
    public void run() {
        Random random = new Random();
        String[] nums = new String[5];
        for (int i = 1; i <= 5; i++) {
            nums[i-1] = i+"";
        }

        for (String num: nums) {
            try {
                System.out.println(color + "Adding..." + num);
                buffer.put(num);
                Thread.sleep(random.nextInt(100));
            } catch (InterruptedException e) {
                System.out.println("Producer was interrupted");
            }
        }

        System.out.println(color + "Adding EOF and exiting");
        try {
            buffer.put(EOF);
        } catch (InterruptedException e) {}
    }
}

class MyConsumer implements Runnable {
    private ArrayBlockingQueue<String> buffer;
    private String color;

    public MyConsumer(ArrayBlockingQueue<String> buffer, String color) {
        this.buffer = buffer;
        this.color = color;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (buffer) {
                try {
                    if (buffer.isEmpty()) {
                        continue;
                    }
                    if (buffer.peek().equals(EOF)) {
                        System.out.println(color + "Exiting");
                        break;
                    } else {
                        System.out.println(color + "Removed " + buffer.take());
                    }
                } catch (InterruptedException e) {}

            }
        }
    }
}
