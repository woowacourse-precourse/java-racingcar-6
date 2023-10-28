package racingcar.domain.validation;

import java.util.Arrays;

public class InputValidator {
    public void validateCarNames(String carNames) {
        if (Arrays.stream(carNames.split(",")).allMatch(s -> s.length() <= 5)) {
            return;
        }
        throw new IllegalArgumentException();
    }

    public void validateTryCount(String tryCount) {
        try {
            Integer.parseInt(tryCount);
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }
}
