package racingcar.utils.validation;

import java.util.List;

public class InputValidation {
    private static void validateNameLength(String carName) {
        if (carName.length() >= 6) {
            throw new IllegalArgumentException();
        }
    }

    private static void validateNameDuplicated(List<String> carNames) {
        long distinctLength = carNames.stream().distinct().count();
        if (carNames.size() != distinctLength) {
            throw new IllegalArgumentException();
        }
    }
}
