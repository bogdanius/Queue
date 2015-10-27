package bogdan.stolyarov;

import java.util.Random;

public class Producer implements Runnable {
    private final BlockingQueue queue;

    public Producer(BlockingQueue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        System.out.println("[Producer] run");
        while (true) {
            try {
                queue.put(produce());
                Thread.currentThread().sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private Integer produce() {
        Integer i = new Random().nextInt(100);
        System.out.println("[Producer] produce: " + i);
        return i;
    }
}
