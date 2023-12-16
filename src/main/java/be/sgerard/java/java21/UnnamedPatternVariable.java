package be.sgerard.java.java21;

public class UnnamedPatternVariable {

    public static void main(String[] args) {
        var r = new Rectangle(90, 87);

        if (r instanceof Rectangle(int w, _)){
            System.out.println(w);
        }
    }

    public record Rectangle(int width, int length){
    }
}
