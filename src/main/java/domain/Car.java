package domain;

import static constant.ConstantString.MOVING_FORWARD;

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
        return carName;
    }

    public void moveOrStop(int randomNumber) {
        if (randomNumber >= MOVING_FORWARD) {
            count.plusCount();
        }
    }

    public int getCount() {
        return count.getCount();
    }
}
