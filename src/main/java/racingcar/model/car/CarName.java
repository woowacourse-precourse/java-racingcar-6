package racingcar.model.car;

import racingcar.util.CarNameValidator;
import racingcar.util.CommonValidator;

public class CarName {
    private static final int LENGTH_LIMIT = 5;

    private final String carName;

    public CarName(String carName) {
        validateName(carName);
        this.carName = carName;
    }

    private void validateName(String carName) {
        CommonValidator.validateBlankCheck(carName,"CARNAME");
        CarNameValidator.validateSpaceCheck(carName);
        CarNameValidator.validateLengthCheck(carName, LENGTH_LIMIT);
    }

    public String getCarName() {
        return carName;
    }
}
