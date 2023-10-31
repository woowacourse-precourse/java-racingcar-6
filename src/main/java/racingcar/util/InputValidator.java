package racingcar.util;

import java.util.Objects;

public final class InputValidator {

    private static final String BLANK_ERROR_MESSAGE = "값을 입력해 주세요.";
    private static final String NULL_ERROR_MESSAGE = "입력 값이 null 입니다.";

    private InputValidator() {
    }

    public static void validateEmptyOrContainBlank(final String input) {
        if (input.isBlank()) {
            throwException(BLANK_ERROR_MESSAGE);
        }
    }

    public static void validateIsNull(final String input) {
        if (Objects.isNull(input)) {
            throwException(NULL_ERROR_MESSAGE);
        }
    }

    private static void throwException(final String errorMessage) {
        throw new IllegalArgumentException(errorMessage);
    }

}
