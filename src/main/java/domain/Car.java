package domain;

import static constant.ConstantString.MOVING_FORWARD;

import validator.NameValidator;

public class Car {
    private final Name carName;
    public final Count count;

    public Car(String carName) {
        NameValidator.validateCarName(carName);
        this.carName = new Name(carName);
        this.count = new Count();
    }

    public String getCarName() {
        return carName.getName();
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
