package be.sgerard.java.java25;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ScopeValue {

    static final ScopedValue<String> USER = ScopedValue.newInstance();

    static void main() {
        try (ExecutorService executor = Executors.newVirtualThreadPerTaskExecutor()) {
            executor.submit(() -> ScopedValue.where(USER, "Alice").run(() -> {
                System.out.println("Thread: " + Thread.currentThread());
                System.out.println("User: " + USER.get());
            }));

            executor.submit(() -> ScopedValue.where(USER, "Bob").run(() -> {
                System.out.println("Thread: " + Thread.currentThread());
                System.out.println("User: " + USER.get());
            }));

            Thread.sleep(200);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

}
