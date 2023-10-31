package racingcar.util;

public final class InputValidator {
    private static final String CAR_NAMES_REGEX = "^(\\w+,)+\\w+$";
    private static final String NUMERIC_REGEX = "\\d+";
    private static final String COMMA = ",";

    public void validateInputFormat(String input) {
        if (!input.matches(CAR_NAMES_REGEX)) {
            throw new IllegalArgumentException(Err.INVALID_CAR_NAMES_FORMAT.getMessage());
        }
    }

    public void validateInputCarCount(String input) {
        if (input.split(COMMA).length == 1) {
            throw new IllegalArgumentException("자동차는 2대 이상 있어야 경주를 시작할 수 있습니다. 다시 입력해 주세요.");
        }
    }


    public void validateNonEmpty(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException(Err.NON_EMPTY_STRING.getMessage());
        }
    }

    public void validateNumericString(String input) {
        if (!input.matches(NUMERIC_REGEX)) {
            throw new IllegalArgumentException(Err.NUMERIC_STRING_ONLY.getMessage());
        }
    }
}
