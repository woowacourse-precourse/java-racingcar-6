package racingcar.validator;

public class CountValidator {
    private static final int MIN_COUNT = 1;

    public static boolean isPositiveNumber(String input) {
        if (Integer.parseInt(input) >= MIN_COUNT) {
            return true;
        }
        return false;
    }

    public static boolean isNumeric(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
