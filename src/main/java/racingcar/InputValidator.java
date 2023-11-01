package racingcar;

public class InputValidator {

    private static final String ERROR_NAME_LENGTH = "이름은 5글자 이하만 가능합니다.";
    private static final String ERROR_EMPTY_NAME = "이름은 공백일 수 없습니다.";
    private static final String REQUIRED_POSITIVE_NUMBER = "입력 값은 1 이상의 숫자여야 합니다.";
    private static final int MAX_NAME_LENGTH = 5;

    public static void validateCarNames(String input) {
        String[] result = input.split(",");

        for (String name : result) {
            if (name.isEmpty() || name.isBlank()) {
                throw new IllegalArgumentException(ERROR_EMPTY_NAME);
            }
            if (name.length() > MAX_NAME_LENGTH) {
                throw new IllegalArgumentException(ERROR_NAME_LENGTH);
            }
        }
    }

    public static void validatePositiveNumber(String input) {
        if (!input.matches("^[1-9]\\d*$")) {
            throw new IllegalArgumentException(REQUIRED_POSITIVE_NUMBER);
        }
    }
}
