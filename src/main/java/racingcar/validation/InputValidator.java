package racingcar.validation;

import java.util.List;
import racingcar.util.ExceptionHandler;

public final class InputValidator {
    public static void isLengthGreaterThanFive(List<String> carNames) {
        boolean stringLengthOverFive = carNames.stream()
                .anyMatch(s -> s.length() > 5);
        if (stringLengthOverFive) {
            ExceptionHandler.throwIfStringLengthOverFive();
        }
    }

    public static void isGreaterThanZero(int tries) {
        if (tries <= 0) {
            ExceptionHandler.throwIfNumberIsZeroOrNegative();
        }
    }
}
