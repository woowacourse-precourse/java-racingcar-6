package racingcar;

public class Validator {
    static public boolean isInteger(String input) {
        try {
            Integer.valueOf(input);
            return true;
        } catch (NumberFormatException ex) {
            //not a number
            return false;
        }
    }

    public static boolean isPositiveInteger(String input) {
        return Integer.parseInt(input) > 0;
    }
}
