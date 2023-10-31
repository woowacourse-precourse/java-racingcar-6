package racingcar.domain;

import racingcar.validate.CarNameValidate;

public class CarName {
    private final String name;

    public CarName(String carName) {
        CarNameValidate.validateCarName(carName);
        this.name = carName;
    }

    public String getName() {
        return name;
    }
}
