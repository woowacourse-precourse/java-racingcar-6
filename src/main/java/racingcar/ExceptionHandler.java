package racingcar;

import java.util.List;

public class ExceptionHandler {

    public void isAttemptException(String attempt) {
        if (!Validation.isNum(attempt)) {
            throw new IllegalArgumentException("시도 횟수가 숫자가 아닙니다.");
        }

        if (Validation.isBlank(attempt)) {
            throw new IllegalArgumentException("시도 횟수가 공백입니다.");
        }

        if (Validation.isNegative(Integer.parseInt(attempt))) {
            throw new IllegalArgumentException("시도 횟수가 0보다 작습니다.");
        }
    }

    public void isCarNamePlainTextException(String str) {
        if (Validation.isBlank(str)) {
            throw new IllegalArgumentException("자동차 이름이 공백입니다.");
        }
    }
}
