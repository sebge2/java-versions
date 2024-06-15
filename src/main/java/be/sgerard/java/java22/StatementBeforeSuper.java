package be.sgerard.java.java22;

import lombok.Getter;

public class StatementBeforeSuper {

    public static void main() {
        System.out.println(new ChildClass(22).getValue());
    }

    @Getter
    public static class ParentClass {

        private final int value;

        public ParentClass(int value) {
            this.value = value;
        }
    }

    public static class ChildClass extends ParentClass {

        public ChildClass(int value) {
            if (value <= 0) {
                throw new IllegalArgumentException("non-positive value");
            }

            super(value);
        }
    }
}
