package racingcar.util;

public final class BlankValidator {
    private static final String BLANK_EXCEPTION = "공백 문자는 입력할 수 없습니다.";

    private BlankValidator() {
    }

    public static void validate(String input) {
        validateBlank(input);
    }

    private static void validateBlank(String input) {
        if (isBlank(input)) {
            throw new IllegalArgumentException(BLANK_EXCEPTION);
        }
    }

    private static boolean isBlank(String input) {
        return input.isBlank();
    }
}
