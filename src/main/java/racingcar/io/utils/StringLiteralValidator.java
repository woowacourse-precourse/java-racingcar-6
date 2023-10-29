package racingcar.io.utils;

public class StringLiteralValidator {

    private StringLiteralValidator() {
    }

    public static void validateIsInteger(String literal) {
        if (!isInteger(literal)) {
            throw new IllegalArgumentException("String literal %s is not numeric.".formatted(literal));
        }
    }

    private static boolean isInteger(String literal) {
        try {
            Integer.parseInt(literal);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static void validateIsPositiveInteger(String literal) {
        validateIsInteger(literal);

        if (!isPositive(Integer.parseInt(literal))) {
            throw new IllegalArgumentException("%s is not positive integer.".formatted(literal));
        }
    }

    private static boolean isPositive(int target) {
        return target > 0;
    }

}
