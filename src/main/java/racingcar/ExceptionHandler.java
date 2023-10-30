package racingcar;

import java.util.List;

public class ExceptionHandler {

    public void isAttemptException(String input) {
        if (!Validation.isNum(input)) {
            throw new IllegalArgumentException("시도 횟수가 숫자가 아닙니다.");
        }
    }
}
