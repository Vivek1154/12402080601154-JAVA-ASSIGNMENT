import java.util.LinkedList;

class SharedBuffer {
    private LinkedList<Integer> buffer = new LinkedList<>();
    private final int CAPACITY = 3; 

    public void produce() throws InterruptedException {
        for (int i = 1; i <= 10; i++) {
            synchronized (this) {
                while (buffer.size() == CAPACITY) {
                    wait();
                }

                System.out.println("Producer produced: " + i);
                buffer.add(i);
                
                notify();
                
                Thread.sleep(500); 
            }
        }
    }

    public void consume() throws InterruptedException {
        for (int i = 1; i <= 10; i++) {
            synchronized (this) {
                while (buffer.isEmpty()) {
                    wait();
                }

                int value = buffer.removeFirst();
                System.out.println("Consumer consumed: " + value);
                
                notify();
                
                Thread.sleep(500);
            }
        }
    }
}

// Main execution class
public class Program2 {
    public static void main(String[] args) {
        SharedBuffer sharedBuffer = new SharedBuffer();

        Thread producer = new Thread(() -> {
            try {
                sharedBuffer.produce();
            } catch (InterruptedException e) {
                System.out.println("Producer interrupted.");
            }
        });

        Thread consumer = new Thread(() -> {
            try {
                sharedBuffer.consume();
            } catch (InterruptedException e) {
                System.out.println("Consumer interrupted.");
            }
        });

        System.out.println("=== Starting Producer-Consumer Process ===\n");
        
        // Start both threads
        producer.start();
        consumer.start();
    }
}
