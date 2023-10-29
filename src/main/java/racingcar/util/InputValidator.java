package racingcar.util;

public final class InputValidator {
    private static final String CAR_NAMES_REGEX = "^(\\w+,)+\\w+$";
    private static final String NUMERIC_REGEX = "\\d+";

    public void validateInputFormat(String input) {
        if (!input.matches(CAR_NAMES_REGEX)) {
            throw new IllegalArgumentException("올바른 입력 형식이 아닙니다.");
        }
    }

    public void validateNonEmpty(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException("입력 문자열은 빈 칸 또는 공백 문자를 포함하면 안됩니다.");
        }
    }

    public void validateNumericString(String input) {
        if (!input.matches(NUMERIC_REGEX)) {
            throw new IllegalArgumentException("1이상의 양수로 된 문자열만 입력할 수 있습니다.");
        }
    }
}
