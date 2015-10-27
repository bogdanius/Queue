package bogdan.stolyarov;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        BlockingQueue queue = new BlockingQueue(5);
        new Thread(new Producer(queue)).start();
        Thread.currentThread().sleep(10000);
        new Thread(new Consumer(queue)).start();
    }
}
