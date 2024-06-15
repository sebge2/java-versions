package be.sgerard.java.java22;

import java.util.concurrent.ThreadLocalRandom;

@SuppressWarnings("preview")
public class ScopedValues {

    private static final ScopedValue<Integer> RANDOM_NUMBER = ScopedValue.newInstance();

    public static void main() {
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                int randomNumber = ThreadLocalRandom.current().nextInt(1, 101);

                ScopedValue.where(RANDOM_NUMBER, randomNumber).run(() -> {
                    System.out.printf("Thread %s: Random number: %d\n", Thread.currentThread().getName(), RANDOM_NUMBER.get());
                });
            }).start();
        }
    }
}
