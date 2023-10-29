package racingcar.util;

import java.util.Objects;

public class InputValidator {

    private static final String BLANK_ERROR_MESSAGE = "값을 입력해 주세요.";
    private static final String NULL_ERROR_MESSAGE = "입력 값이 null 입니다.";

    private InputValidator() {
    }

    public static void isBlankInput(String input) {
        if (input.isBlank()) {
            throwError(BLANK_ERROR_MESSAGE);
        }
    }

    public static void isNullInput(String input) {
        if (Objects.isNull(input)) {
            throwError(NULL_ERROR_MESSAGE);
        }
    }

    private static void throwError(String errorMessage) {
        throw new IllegalArgumentException(errorMessage);
    }

}
