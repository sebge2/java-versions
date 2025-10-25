package be.sgerard.java.java25;

public class SuperConstructor {

    public class Parent {

        private final String name;

        public Parent(String name) {
            this.name = name;
        }
    }

    public class Child extends Parent {


        public Child(String name) {
            if(name == null){
                throw new IllegalArgumentException("name cannot be null");
            }

            super(name);
        }
    }

}
