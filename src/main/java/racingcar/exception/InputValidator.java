package racingcar.exception;

public class InputValidator {

    private static final String EMPTY_INPUT_ERROR_MESSAGE = "입력값이 비어있습니다.";
    private static final String CHARACTERS_IN_INPUT_ERROR_MESSAGE = "입력값에 문자가 포함되어 있습니다";

    private InputValidator() {
    }

    public static void validateInputCarNames(String carNames) {
        if (carNames.isEmpty()) {
            throw new IllegalArgumentException(EMPTY_INPUT_ERROR_MESSAGE);
        }
    }

    public static void validateInputTryNumber(String number) {
        if (number.isEmpty()) {
            throw new IllegalArgumentException(EMPTY_INPUT_ERROR_MESSAGE);
        }
        if (!isNumeric(number)) {
            throw new IllegalArgumentException(CHARACTERS_IN_INPUT_ERROR_MESSAGE);
        }
    }

    private static boolean isNumeric(String number) {
        try {
            Integer.parseInt(number);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}