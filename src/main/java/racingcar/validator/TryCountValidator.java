package racingcar.validator;

import static java.lang.Integer.*;

public class TryCountValidator {

    private TryCountValidator() {

    }

    public static void validate(String tryCount) {
        validateEmpty(tryCount);
        validateDigit(tryCount);
        validateSign(tryCount);
    }

    private static void validateEmpty(String tryCount) {
        if (tryCount.isEmpty()) {
            throw new IllegalArgumentException("입력값은 비어있지 않아야 합니다.");
        }
    }

    private static void validateDigit(String tryCount) {
        if (tryCount.chars().anyMatch(ch -> !Character.isDigit(ch))) {
            throw new IllegalArgumentException("입력값은 정수이어야 합니다.");
        }
    }

    private static void validateSign(String tryCount) {
        if (parseInt(tryCount) <= 0) {
            throw new IllegalArgumentException("입력값은 양의 정수이어야 합니다.");
        }
    }
}
