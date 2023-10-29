package racingcar.validator;

import static java.lang.Character.*;
import static java.lang.Integer.*;

public class GameCountValidator {

    public static void validate(String gameCount) {
        validateIsEmpty(gameCount);
        validateIsDigit(gameCount);
        validateSign(gameCount);
    }

    private static void validateIsEmpty(String gameCount) {
        if (gameCount.isEmpty()) {
            throw new IllegalArgumentException("입력값은 비어있지 않아야 합니다.");
        }
    }

    private static void validateIsDigit(String gameCount) {
        if (!isDigit(parseInt(gameCount))) {
            throw new IllegalArgumentException("입력값은 정수이어야 합니다.");
        }
    }

    private static void validateSign(String gameCount) {
        if (parseInt(gameCount) <= 0) {
            throw new IllegalArgumentException("입력값은 양의 정수이어야 합니다.");
        }
    }
}
