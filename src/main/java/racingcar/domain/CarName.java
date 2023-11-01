package racingcar.domain;

import static racingcar.message.RacingCarErrorMessage.NOT_CAR_NAME_LENGTH_CORRECT;

public record CarName(String name) {

    private static final int CAR_NAME_LENGTH_MAX = 5;

    public CarName {
        isCarNameLengthValidate(name);
    }

    private void isCarNameLengthValidate(final String carName) {
        if (carName.isEmpty() || carName.length() > CAR_NAME_LENGTH_MAX) {
            throw new IllegalArgumentException(NOT_CAR_NAME_LENGTH_CORRECT.getMessage());
        }
    }

}