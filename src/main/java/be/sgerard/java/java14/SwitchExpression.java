package be.sgerard.java.java14;

public class SwitchExpression {

    public static void main(String[] args) {
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

    private enum Day {
        SUNDAY, MONDAY, TUESDAY,
        WEDNESDAY, THURSDAY, FRIDAY, SATURDAY;
    }
}
