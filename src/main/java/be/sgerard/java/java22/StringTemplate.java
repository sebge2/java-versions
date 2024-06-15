package be.sgerard.java.java22;

@SuppressWarnings("preview")
public class StringTemplate {

    public static void main() {
        String firstName = "Pravin";
        String lastName = "Choudhary";
        String address = "United Kingdom";
        String jsonData = STR.
                """
                          {
                            "name":"\{firstName + " " + lastName}",
                            "address":"\{address}"
                          }
                        """;

        System.out.println(jsonData);
    }
}
