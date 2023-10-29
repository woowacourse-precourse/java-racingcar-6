package racingcar.util;

import java.util.List;

public class InputValidator {
    private static final String DIGIT = "^[0-9]+$";
    private static final String INVALID_NAME_LENGTH_EXCEPTION_MESSAGE = "자동차의 이름 길이는 1이상 5이하입니다.";
    private static final String INVALID_ATTEMPT_NUMBER_RANGE_EXCEPTION_MESSAGE = "시도 횟수는 1이상입니다.";
    private static final String INVALID_NUMBER_EXCEPTION_MESSAGE = "숫자만 입력 가능합니다.";

    public void validateCarNames(List<String> carNames) {
        checkNameLength(carNames);
    }

    public void validateAttemptNumber(String input) {
        if (isNotNumber(input)) {
            throw new IllegalArgumentException(INVALID_NUMBER_EXCEPTION_MESSAGE);
        }
        if (isInvalidRange(input)) {
            throw new IllegalArgumentException(INVALID_ATTEMPT_NUMBER_RANGE_EXCEPTION_MESSAGE);
        }
    }

    private void checkNameLength(List<String> carNames) {
        for (String name : carNames) {
            if (name.length() < 1 || name.length() > 5) {
                throw new IllegalArgumentException(INVALID_NAME_LENGTH_EXCEPTION_MESSAGE);
            }
        }
    }

    private boolean isNotNumber(String number) {
        return !number.matches(DIGIT);
    }

    private boolean isInvalidRange(String number) {
        return Integer.parseInt(number) < 1;
    }
}
