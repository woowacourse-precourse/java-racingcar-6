package racingcar.domain.validation;

import java.util.Arrays;

public class InputValidator {
    public void validateInput(String carNames) {
        if (Arrays.stream(carNames.split(",")).allMatch(s -> s.length() <= 5)) {
            return;
        }
        throw new IllegalArgumentException();
    }
}
