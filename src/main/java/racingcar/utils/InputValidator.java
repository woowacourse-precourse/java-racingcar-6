package racingcar.utils;

import java.util.List;

public class InputValidator {

    private static final int CAR_NAME_LENGTH = 5;
    private static final String CAR_NAME_LENGTH_ERROR_MESSAGE = "자동차 이름은 0자 이상 5자 이하만 가능합니다.";
    private static final String NON_INTEGER_MESSAGE = "시도 횟수는 정수여야 합니다.";
    private static final String NON_POSITIVE_MESSAGE = "시도 횟수는 0보다 커야 합니다.";


    public static void validateCarNames(List<String> carNames) {
        for (String carName : carNames) {
            validateCarNameLength(carName);
        }
    }

    private static void validateCarNameLength(String carName) {
        if (carName.length() > CAR_NAME_LENGTH || carName.trim().isEmpty()) {
            throw new IllegalArgumentException(CAR_NAME_LENGTH_ERROR_MESSAGE);
        }
    }


    public static int validateAttemptCount(String attemptCount) {
        try {
            int parsedCount = Integer.parseInt(attemptCount);
            validatePositiveCount(parsedCount);
            return parsedCount;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NON_INTEGER_MESSAGE, e);
        }
    }


    private static void validatePositiveCount(int parsedCount) {
        if (parsedCount <= 0) {
            throw new IllegalArgumentException(NON_POSITIVE_MESSAGE);
        }
    }

}
