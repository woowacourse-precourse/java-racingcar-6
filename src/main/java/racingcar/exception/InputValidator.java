package racingcar.exception;

public class InputValidator {

    private static final String EMPTY_INPUT_ERROR_MSG = "입력값이 비어있습니다.";

    private InputValidator() {
    }

    public static void validateInputCarNames(String carNames) {
        if (carNames.isEmpty()) {
            throw new IllegalArgumentException(EMPTY_INPUT_ERROR_MSG);
        }
    }
}
