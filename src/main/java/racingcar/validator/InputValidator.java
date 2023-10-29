package racingcar.validator;

public class InputValidator {

    public static void validateTryCountInput(String input) {
        validateCanParseInteger(input);
        validateNonNegativeInteger(Integer.parseInt(input));
    }

    private static void validateCanParseInteger(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    private static void validateNonNegativeInteger(Integer integer) {
        if (integer < 0) {
            throw new IllegalArgumentException();
        }
    }
}
