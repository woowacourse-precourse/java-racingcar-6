package racingcar;

import java.util.List;

public class ExceptionHandler {

    public void isAttemptException(String input) {
        if (!Validation.isNum(input)) {
            throw new IllegalArgumentException("시도 횟수가 숫자가 아닙니다.");
        }

        if (Validation.isBlank(input)) {
            throw new IllegalArgumentException("시도 횟수가 공백입니다.");
        }

        if (Validation.isNegative(Integer.parseInt(input))) {
            throw new IllegalArgumentException("시도 횟수가 0보다 작습니다.");
        }
    }
}
