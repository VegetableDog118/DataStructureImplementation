package QUEUE;

import org.w3c.dom.ls.LSOutput;

import javax.crypto.spec.PSource;
import javax.management.Query;
import java.util.Random;

public class TestComparingTwoQueue {
    private static double testQueue(Queue<Integer> queue, int count) {
        long startTime = System.nanoTime();
        Random random = new Random();
        for (int i = 0; i < count; i++) {
            queue.enqueue(random.nextInt(Integer.MAX_VALUE));
        }
        for (int i = 0; i < count; i++) {
            queue.dequeue();
        }
        long endTime = System.nanoTime();

        return (endTime - startTime) / 1000000000;
    }

    public static void main(String[] args) {
        int count = 100000;
        LoopQueue loopQueue = new LoopQueue();
        System.out.println(testQueue(loopQueue, count));


        QueueArray queueArray = new QueueArray();
        System.out.println(testQueue(queueArray, count));
        
    }

}