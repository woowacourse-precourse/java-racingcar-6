package racingcar.util;

public class CarValidator {
    private static final String INVALID_INPUT_IS_EMPTY_MESSAGE = "입력값이 공백입니다.";
    private static final String INVALID_INPUT_SIZE_MESSAGE = "입력은 5자 이하입니다.";

    public static void validateCarName(String name) {
        validateInputNotEmpty(name);
        validateInputSize(name);
    }

    private static void validateInputNotEmpty(String name) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException(INVALID_INPUT_IS_EMPTY_MESSAGE);
        }
    }

    private static void validateInputSize(String name) {
        if (Constants.MAX_INPUT_SIZE < name.length())
            throw new IllegalArgumentException(INVALID_INPUT_SIZE_MESSAGE);
    }

}
