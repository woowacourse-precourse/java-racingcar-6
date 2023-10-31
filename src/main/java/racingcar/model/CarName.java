package racingcar.model;

import racingcar.util.CarNameValidator;

public class CarName {
    private static final int LENGTH_LIMIT = 5;

    private final String carName;

    public CarName(String carName) {
        validateName(carName);
        this.carName = carName;
    }

    private void validateName(String carName) {
        CarNameValidator.validateEmptyCheck(carName);
        CarNameValidator.validateSpaceCheck(carName);
        CarNameValidator.validateLengthCheck(carName, LENGTH_LIMIT);
    }

    public String getCarName() {
        return carName;
    }
}
