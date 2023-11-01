package racingcar.utils;

public class ValidationUtil {
    private static final int MAX_CAR_NAME_LENGTH = 5;
    public static final String ERROR_CAR_NAME_EMPTY = "자동차 이름은 최소 1자 이상이어야 합니다.";
    public static final String ERROR_CAR_NAME_LENGTH = "자동차 이름은 최대 5자까지 가능합니다.";
    public static final String ERROR_ATTEMPT_NUMBER_NOT_POSITIVE = "시도 횟수는 1 이상의 정수여야 합니다.";
    public static final String ERROR_CAR_NAMES_EMPTY = "자동차 이름은 최소 1개 이상이어야 합니다.";
    public static final String ERROR_ATTEMPT_STRING_NOT_NUMERIC = "시도 횟수는 숫자여야 합니다.";

    private ValidationUtil() {
    }

    public static void validateCarName(String carName) {
        if (carName.isEmpty()) {
            throw new IllegalArgumentException(ERROR_CAR_NAME_EMPTY);
        }
        if (carName.length() > MAX_CAR_NAME_LENGTH) {
            throw new IllegalArgumentException(ERROR_CAR_NAME_LENGTH);
        }
    }

    public static void validateAttemptNumber(int number) {
        if (number <= 0) {
            throw new IllegalArgumentException(ERROR_ATTEMPT_NUMBER_NOT_POSITIVE);
        }
    }

    public static void validateCarNames(String[] carNames) {
        if (carNames.length == 0) {
            throw new IllegalArgumentException(ERROR_CAR_NAMES_EMPTY);
        }
    }

    public static void validateIsNumeric(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_ATTEMPT_STRING_NOT_NUMERIC);
        }
    }
}

