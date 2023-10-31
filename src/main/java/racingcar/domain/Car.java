package racingcar.domain;

import racingcar.validator.CarNameValidator;

public class Car {
    private final String carName;
    private int position;

    public Car(String carName) {
        CarNameValidator.validate(carName);
        this.carName = carName;
        this.position = 0;
    }

    public String getCarName() {
        return carName;
    }

    public int getPosition() {
        return position;
    }

    public void moveForward() {
        this.position++;
    }
}
