package racingcar.utils;

public class CarNamesInputValidator {
    public static void validate(String target) {
        validateIsNotBlank(target);
        validateFirstCharacterIsNotComma(target);
        validateLastCharacterIsNotComma(target);

        String[] elements = target.split(",");
        validateEachElementIsNotBlank(elements);
        validateEachElementCorrectLength(elements);
    }

    private static void validateIsNotBlank(String target) {
        if (target.isBlank()) {
            throw new IllegalArgumentException(ExceptionMessage.BLANK.getError());
        }
    }

    private static void validateFirstCharacterIsNotComma(String target) {
        if (target.charAt(0) == ',') {
            throw new IllegalArgumentException(ExceptionMessage.FIRST_CHARACTER_COMMA.getError());
        }
    }

    private static void validateLastCharacterIsNotComma(String target) {
        if (target.charAt(target.length() - 1) == ',') {
            throw new IllegalArgumentException(ExceptionMessage.LAST_CHARACTER_COMMA.getError());
        }
    }

    private static void validateEachElementIsNotBlank(String[] targets) {
        for (String target : targets) {
            if (target.isBlank()) {
                throw new IllegalArgumentException(ExceptionMessage.ELEMENT_BLANK.getError());
            }
        }
    }

    private static void validateEachElementCorrectLength(String[] targets) {
        for (String target : targets) {
            if (target.length() > 5) {
                throw new IllegalArgumentException(ExceptionMessage.OUT_OF_LENGTH.getError());
            }
        }
    }
}
