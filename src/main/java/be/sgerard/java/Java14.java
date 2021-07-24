package be.sgerard.java;

/**
 * @author Sebastien Gerard
 */
public class Java14 {

    public static void main(String[] args) {
        switchExpressions();
        textBlocks();;
    }

    private static void switchExpressions() {
        var day = Day.FRIDAY;

        var mySwitchValue = switch (day) {
            case FRIDAY:
                yield "This is friday";
            case SATURDAY:
            case SUNDAY:
                yield "This is week-end";
            default:
                yield "this is not friday";
        };

        System.out.println(mySwitchValue);
    }

    private static void textBlocks(){
        var text = """
                multiple
				line
				""";

        System.out.println(text);
    }

    private enum Day {
        SUNDAY, MONDAY, TUESDAY,
        WEDNESDAY, THURSDAY, FRIDAY, SATURDAY;
    }
}
