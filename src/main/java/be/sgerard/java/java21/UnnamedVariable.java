package be.sgerard.java.java21;

import java.util.List;

import static java.util.Arrays.asList;

public class UnnamedVariable {

    public static void main(String[] args) {
        final List<String> cars = asList("first", "second");

        int total = 0;

        for (var _ : cars) {
            total++;
        }

        System.out.println(total);
    }
}
