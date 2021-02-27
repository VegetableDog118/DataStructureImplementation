package interview;

import java.util.LinkedList;

public class ConsumerProducer2 {

    static class MessageQueue{

        private LinkedList<Message> list = new LinkedList<>();

        private int capacity;

        public MessageQueue( int capacity){
            this.capacity = capacity;
        }

        public Message get() throws InterruptedException {
            synchronized (list){
                while(list.isEmpty()){
                    System.out.println("queue is empty");
                    list.wait();
                }
                Message message = list.removeFirst();
                System.out.println("consume 1 message from queue " + message);
                list.notifyAll();
                return message;
            }
        }

        public void put(Message message) throws InterruptedException {
            synchronized (list){
                while (list.size() == capacity){
                    System.out.println("queue is full");
                    list.wait();
                }
                list.add(message);
                System.out.println("add one message to queue" + message);
                list.notifyAll();
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

        MessageQueue messageQueue = new MessageQueue(5);

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
