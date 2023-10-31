package racingcar.vo;

import static racingcar.constants.Integers.MAX_CAR_NAME_LENGTH;

import racingcar.exception.CarNameLengthExceedException;

public class CarName {

    private final String carName;

    public CarName(String carName) {
        checkNameLength(carName);
        this.carName = carName;
    }

    private void checkNameLength(String name) {
        if (name.length() > MAX_CAR_NAME_LENGTH.show()) {
            throw new CarNameLengthExceedException();
        }
    }


    public String show() {
        return carName;
    }
}
