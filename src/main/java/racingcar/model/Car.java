package racingcar.model;

import racingcar.validation.CarNameValidator;

public class Car {
    private static final int MOVEMENT_THRESHOLD = 4;
    private final String name;
    private int position = 0;

    public Car(final String name) {
        final CarNameValidator carNameValidator = CarNameValidator.getInstance();
        carNameValidator.validate(name);
        this.name = name;
    }

    public void moveForward(final int randomNumber) {
        if (isMoveForward(randomNumber)) {
            position++;
        }
    }

    private boolean isMoveForward(final int randomNumber) {
        return randomNumber >= MOVEMENT_THRESHOLD;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
