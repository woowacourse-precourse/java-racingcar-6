package racingcar.utils;

public class ValidationUtil {
    private static final int MAX_CAR_NAME_LENGTH = 5;

    private ValidationUtil() {
    }

    public static void validateCarName(String carName) {
        if (carName.length() > MAX_CAR_NAME_LENGTH) {
            throw new IllegalArgumentException("자동차 이름은 최대 5자까지 가능합니다.");
        }
    }

    public static void validateAttemptNumber(int number) {
        if (number <= 0) {
            throw new IllegalArgumentException("시도 횟수는 1 이상의 정수여야 합니다.");
        }
    }
}

