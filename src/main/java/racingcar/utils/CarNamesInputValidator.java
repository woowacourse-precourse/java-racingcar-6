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
            throw new IllegalArgumentException(CarNamesInputExceptionMessage.BLANK.getError());
        }
    }

    private static void validateFirstCharacterIsNotComma(String target) {
        if (target.charAt(0) == COMMA) {
            throw new IllegalArgumentException(CarNamesInputExceptionMessage.FIRST_CHARACTER_COMMA.getError());
        }
    }

    private static void validateLastCharacterIsNotComma(String target) {
        if (target.charAt(target.length() - 1) == COMMA) {
            throw new IllegalArgumentException(CarNamesInputExceptionMessage.LAST_CHARACTER_COMMA.getError());
        }
    }

    private static void validateEachElementIsNotBlank(String[] targets) {
        for (String target : targets) {
            if (target.isBlank()) {
                throw new IllegalArgumentException(CarNamesInputExceptionMessage.ELEMENT_BLANK.getError());
            }
        }
    }

    private static void validateEachElementCorrectLength(String[] targets) {
        for (String target : targets) {
            if (target.length() > VALID_MAX_LENGTH) {
                throw new IllegalArgumentException(CarNamesInputExceptionMessage.OUT_OF_LENGTH.getError());
            }
        }
    }

    enum CarNamesInputExceptionMessage {
        BLANK("공백 입력을 해선 안됩니다."),
        FIRST_CHARACTER_COMMA("첫 번째 문자로 콤마(,)를 입력하면 안됩니다."),
        LAST_CHARACTER_COMMA("마지막 문자로 콤마(,)를 입력하면 안됩니다."),
        ELEMENT_BLANK("자동차 이름은 공백 문자로만 이루어져선 안됩니다."),
        OUT_OF_LENGTH("자동차 이름은 5글자 이하여야 합니다.");

        private final String error;

        CarNamesInputExceptionMessage(String error) {
            this.error = error;
        }

        String getError() {
            return error;
        }
    }
}
