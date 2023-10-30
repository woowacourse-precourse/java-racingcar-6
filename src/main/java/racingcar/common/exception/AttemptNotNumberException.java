package racingcar.common.exception;

import racingcar.common.constant.GuidePhrases;

import java.util.List;

public class AttemptNotNumberException {
    public static void notNumber(String attemptNumber) {
        try {
            Integer.parseInt(attemptNumber);
        } catch (Exception e) {
            throw new IllegalArgumentException("숫자가 아닌 문자가 입력됨");
        }
    }
}
