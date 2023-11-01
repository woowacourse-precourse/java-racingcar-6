package racingcar.util;

import static racingcar.constant.GameOptions.MAX_NAME_LENGTH;

import java.util.List;

public class Validator {
    public void validateCarName(String carName) {
        validateNotBlank(carName);
        validateFirstChar(carName);
        validateLastChar(carName);
        validateLength(carName);
    }

    private void validateNotBlank(String carName) {
        if (carName.isBlank()) {
            throw new IllegalArgumentException();
        }
    }

    private void validateFirstChar(String carName) {
        boolean hasLeadingSpace = carName.startsWith(" ");
        if (hasLeadingSpace) {
            throw new IllegalArgumentException();
        }
    }

    private void validateLastChar(String carName) {
        boolean hasTrailingSpace = carName.endsWith(" ");
        if (hasTrailingSpace) {
            throw new IllegalArgumentException();
        }
    }

    private void validateLength(String carName) {
        boolean isOverLimit = carName.length() > MAX_NAME_LENGTH;
        if (isOverLimit) {
            throw new IllegalArgumentException();
        }
    }
}
