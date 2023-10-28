package racingcar.validation;

import java.util.regex.Pattern;

public class InputValidator {

    private static final Pattern ONLY_NUMBER_PATTERN = Pattern.compile("^[0-9]*$");

    private static final String INVALID_TRY_NUMBER_MESSAGE = "시도할 횟수는 숫자만 입력 가능합니다.";
    public void validateTryCount(String tryCount) {
        if (isMatchNumber(tryCount)) {
            throw new IllegalArgumentException(INVALID_TRY_NUMBER_MESSAGE);
        }
    }

    private boolean isMatchNumber(String tryCount) {
        return !ONLY_NUMBER_PATTERN.matcher(tryCount).matches();
    }
}


