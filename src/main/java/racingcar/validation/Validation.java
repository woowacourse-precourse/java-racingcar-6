package racingcar.validation;

import java.util.List;

public class Validation {
    private static final int MAX_RACING_TIME = 5;

    public static void inputCarNameValidate(List<String> carNames) {
        if (carNames.stream()
                .filter(carName -> carName.isEmpty() || carName.length() > MAX_RACING_TIME)
                .count() == carNames.size()
        ) {
            throw new IllegalArgumentException();
        }

    }

}
