package racingcar.service;

import java.util.Arrays;
import java.util.List;
import racingcar.validation.ExceptionHandler;

public class RacingService {
    public List<String> stringToList(String input) {
        return Arrays.asList(input.split(","));
    }

    public void isLengthGreaterThanFive(List<String> carNames) {
        boolean stringLengthOverFive = carNames.stream()
                .anyMatch(s -> s.length() > 5);
        if (stringLengthOverFive) {
            ExceptionHandler.throwIfStringLengthOverFive();
        }
    }

    public void isGreaterThanZero(int tries) {
        if (tries <= 0) {
            ExceptionHandler.throwIfNumberIsZeroOrNegative();
        }
    }
}
