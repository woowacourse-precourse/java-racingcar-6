package racingcar.utils;

public class CarNamesInputValidator {

    private static final String SPLIT_REGEX = ",";
    private static final char COMMA = ',';
    private static final int VALID_MAX_LENGTH = 5;


    public static void validate(String target) {
        validateIsNotBlank(target);
        validateFirstCharacterIsNotComma(target);
        validateLastCharacterIsNotComma(target);

        String[] elements = target.split(SPLIT_REGEX);
        validateEachElementIsNotBlank(elements);
        validateEachElementCorrectLength(elements);
    }

    private static void validateIsNotBlank(String target) {
        if (target.isBlank()) {
            throw new IllegalArgumentException(ExceptionMessage.BLANK.getError());
        }
    }

    private static void validateFirstCharacterIsNotComma(String target) {
        if (target.charAt(0) == COMMA) {
            throw new IllegalArgumentException(ExceptionMessage.FIRST_CHARACTER_COMMA.getError());
        }
    }

    private static void validateLastCharacterIsNotComma(String target) {
        if (target.charAt(target.length() - 1) == COMMA) {
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
            if (target.length() > VALID_MAX_LENGTH) {
                throw new IllegalArgumentException(ExceptionMessage.OUT_OF_LENGTH.getError());
            }
        }
    }
}
