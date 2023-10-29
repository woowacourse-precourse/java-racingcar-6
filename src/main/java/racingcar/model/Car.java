package racingcar.model;

import racingcar.validation.CarValidator;

public class Car {

    private String carName;

    public Car(String carName) {
        CarValidator.validateCarName(carName);
        this.carName = carName;
    }
}
