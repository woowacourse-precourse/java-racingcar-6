package racingcar.io.utils;

public class StringLiteralValidator {

    private StringLiteralValidator() {
    }

    public static void validateIsNumeric(String literal) {
        if (!isNumeric(literal)) {
            throw new IllegalArgumentException("String literal %s is not numeric.".formatted(literal));
        }
    }

    private static boolean isNumeric(String literal) {
        return literal.chars()
                .allMatch(Character::isDigit);
    }

}
