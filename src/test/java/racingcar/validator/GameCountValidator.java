package racingcar.validator;

import static java.lang.Character.*;
import static java.lang.Integer.*;

public class GameCountValidator {

    private void validateIsEmpty(String gameCount) {
        if (gameCount.isEmpty()) {
            throw new IllegalArgumentException("입력값은 비어있지 않아야 합니다.");
        }
    }

    private void validateIsDigit(String gameCount) {
        if (!isDigit(parseInt(gameCount))) {
            throw new IllegalArgumentException("입력값은 정수이어야 합니다.");
        }
    }
}
