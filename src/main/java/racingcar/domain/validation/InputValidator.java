package racingcar.domain.validation;

import java.util.Arrays;

public class InputValidator {
    public void validateCarNames(String carNames) {
        if (!carNames.chars().allMatch(c -> c == ',') &&
                Arrays.stream(carNames.split(",")).allMatch(s -> s.length() <= 5 &&
                        !s.equals(" "))) {
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
