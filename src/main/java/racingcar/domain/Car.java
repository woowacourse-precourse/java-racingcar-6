package racingcar.domain;

import racingcar.util.CarValidator;
import racingcar.util.Constants;

public class Car {
    private final String name;
    private int position = Constants.INITIAL_POSITION;

    public Car(String name) {
        String trimmedName = name.trim();

        CarValidator.validateCarName(trimmedName);

        this.name = trimmedName;
    }

    public int compareTo(Car car) {
        return this.position - car.position;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public boolean isSamePosition(Car car) {
        return car.position == this.position;
    }

    public void moveForward(int randomNumber) {
        if (randomNumber >= Constants.MIN_MOVE_THRESHOLD) {
            increasePosition();
        }
    }

    private void increasePosition() {
        this.position++;
    }
}
