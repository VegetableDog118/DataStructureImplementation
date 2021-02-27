package interview;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConsumerProducer {

    static class MessageQueue{

        private LinkedList<Message> list = new LinkedList<>();

        private int capacity;
        private static ReentrantLock lock = new ReentrantLock();

        private static Condition producerCondition = lock.newCondition();
        private static Condition consumerCondition = lock.newCondition();


        public MessageQueue( int capacity){
            this.capacity = capacity;
        }

        public Message get() throws InterruptedException {
                lock.lock();
                try{
                    while (list.isEmpty()){
                        System.out.println("queue is Empty");
                        consumerCondition.await();
                    }
                    Message message = list.removeFirst();
                    System.out.println("consume 1 message from queue " + message);
                    producerCondition.signalAll();
                    return message;
                }finally {
                    lock.unlock();
                }

        }

        public void put(Message message) throws InterruptedException {
            lock.lock();
            try{
                while (list.size() == capacity){
                    System.out.println("queue is full");
                    consumerCondition.await();
                }
                list.add(message);
                System.out.println("add one message to queue" + message);
                producerCondition.signalAll();

            }finally {
                lock.unlock();
            }
        }
    }

    static class Message{

        private int id;

        private Object value;

        public Message(int id , Object value){
            this.id = id;
            this.value = value;
        }

        public String toString(){
            return "Message:" + id + "-" + value;
        }
    }

    public static void main(String[] args) {
        MessageQueue messageQueue = new MessageQueue(2);

        for(int i = 1 ; i <=3 ; i++){
            int id = i;
            new Thread(()->{
                try {
                    messageQueue.put(new Message(id," product"));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }

        new Thread(()->{
            while (true){


                try {
                    Message message = messageQueue.get();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }).start();
    }


}
