package be.sgerard.java.java19;

import java.time.Duration;
import java.time.Instant;

public class VirtualThread {

    private final static Duration SINGLE_PROCESS_TIME = Duration.ofSeconds(6);

    public static void main(String[] args) throws InterruptedException {
        // https://www.youtube.com/watch?v=PBCV50tUlJQ
        final Instant start = Instant.now();
        Thread lastThread = null;

        final int maxThreads = 1_000_000;

        for (int i = 0; i < maxThreads; i++) {
            lastThread = createThread(i);
            lastThread.start();

            if (i % 5000 == 0) {
                System.out.printf("Current count %d%n", i);
            }
        }

        lastThread.join();

        final Instant stop = Instant.now();
        final Duration duration = Duration.between(start, stop);
        System.out.printf("Finishing running %d threads, took %s%n", maxThreads, duration);
    }

    private static Thread createThread(int i) {
        Runnable job = () -> {
            try {
                Thread.sleep(SINGLE_PROCESS_TIME.toMillis());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        };

        return Thread.ofVirtual().unstarted(job);
    }
}
