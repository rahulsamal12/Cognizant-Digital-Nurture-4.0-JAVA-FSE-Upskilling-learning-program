import java.time.Duration;
import java.time.Instant;

public class VirtualThreadsDemo {
    public static void main(String[] args) throws InterruptedException {
        int threadCount = 10;

        System.out.println("Starting with Virtual Threads...");
        Instant startVirtual = Instant.now();

        Thread[] virtualThreads = new Thread[threadCount];
        for (int i = 0; i < threadCount; i++) {
            virtualThreads[i] = Thread.startVirtualThread(() -> {
                System.out.println("Hello from virtual thread " + Thread.currentThread());
            });
        }
        for (Thread t : virtualThreads) {
            t.join();
        }

        Instant endVirtual = Instant.now();
        System.out.println("Virtual threads finished in: " + Duration.between(startVirtual, endVirtual).toMillis() + " ms\n");

        // Optional: You may comment this out to avoid heavy system load.
        System.out.println("Starting with Platform (Traditional) Threads...");
        Instant startPlatform = Instant.now();

        Thread[] platformThreads = new Thread[threadCount];
        for (int i = 0; i < threadCount; i++) {
            platformThreads[i] = new Thread(() -> {
                System.out.println("Hello from platform thread " + Thread.currentThread());
            });
            platformThreads[i].start();
        }
        for (Thread t : platformThreads) {
            t.join();
        }

        Instant endPlatform = Instant.now();
        System.out.println("Platform threads finished in: " + Duration.between(startPlatform, endPlatform).toMillis() + " ms");
    }
}
