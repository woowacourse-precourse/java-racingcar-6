package racingcar.validation;

import java.util.regex.Pattern;

public class InputValidator {

    private static final String INVALID_TRY_COUNT_MESSAGE = "시도할 횟수는 숫자만 입력 가능합니다.";
    private static final String INPUT_NOT_BLANK_MESSAGE = "입력은 공백일 수 없습니다.";
    private static final String INPUT_NOT_EMPTY_MESSAGE = "입력은 비어있을 수 없습니다.";


    private static final Pattern ONLY_NUMBER_PATTERN = Pattern.compile("^[0-9]*$");

    public void validateInputEmpty(String input) {
        if (isEmpty(input)) {
            throw new IllegalArgumentException(INPUT_NOT_EMPTY_MESSAGE);
        }
    }

    public void validateInputBlank(String input) {
        if (isBlank(input)) {
            throw new IllegalArgumentException(INPUT_NOT_BLANK_MESSAGE);
        }
    }
    public void validateTryCount(String tryCount) {
        if (isMatchNumber(tryCount)) {
            throw new IllegalArgumentException(INVALID_TRY_COUNT_MESSAGE);
        }
    }

    private boolean isEmpty(String input) {
        return !(input.isEmpty());
    }

    private boolean isBlank(String input) {
        return !input.isBlank();
    }

    private boolean isMatchNumber(String tryCount) {
        return !ONLY_NUMBER_PATTERN.matcher(tryCount).matches();
    }
}


