package bogdan.stolyarov;

public class Consumer implements Runnable {
    private final BlockingQueue queue;

    public Consumer(BlockingQueue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        System.out.println("[Consumer] run");
        while (true) {
            try {
                consume();
                Thread.currentThread().sleep(1500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void consume() throws InterruptedException {
        Integer i = (Integer) queue.take();
        System.out.println("[Consumer] consumed: " + i);
    }
}
