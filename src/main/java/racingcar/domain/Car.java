package racingcar.domain;

import racingcar.util.CarValidator;
import racingcar.util.Constants;

public class Car {
    private final String name;
    private int position = Constants.INITIAL_POSITION;

    public Car(String name) {
        String trimmedName = getTrimmedName(name);

        CarValidator.validateCarName(trimmedName);

        this.name = trimmedName;
    }

    public void moveForward(int randomNumber) {
        if (randomNumber >= Constants.MIN_MOVE_THRESHOLD) {
            increasePosition();
        }
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    private String getTrimmedName(String name) {
        return name.trim();
    }

    private void increasePosition() {
        this.position++;
    }

}
