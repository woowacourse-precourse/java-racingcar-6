package domain;

import validator.NameValidator;

public class Car {
    private final String carName;
    public final Count count;

    public Car(String carName) {
        NameValidator.validateCarName(carName);
        this.carName = carName;
        this.count = new Count();
    }

    public String getCarName() {
        return this.carName;
    }

    public void moveOrStop(int randomNumber) {
        if (randomNumber >= 4) {
            count.plusForward();
        }
    }
}
