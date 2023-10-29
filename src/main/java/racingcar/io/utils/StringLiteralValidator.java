package racingcar.io.utils;

public class StringLiteralValidator {

    private StringLiteralValidator() {
    }

    public static void validateIsDigit(String literal) {
        if (!isDigit(literal)) {
            throw new IllegalArgumentException("String literal %s is not numeric.".formatted(literal));
        }
    }

    private static boolean isDigit(String literal) {
        return literal.chars()
                .allMatch(Character::isDigit);
    }

    public static void validateIsPositiveInteger(String literal) {
        validateIsDigit(literal);
    }

}
