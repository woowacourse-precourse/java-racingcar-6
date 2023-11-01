package racingcar.domain;

import static racingcar.util.GameConstants.CAR_INITIAL_POSITION;

public class Car {
    private final CarName carName;
    private int position;

    private Car(String name) {
        this.carName = CarName.of(name);
        this.position = CAR_INITIAL_POSITION.getValue();
    }

    public static Car create(String name) {
        return new Car(name);
    }

    public void moveForward() {
        position++;
    }

    public String combineCarNameAndPosition() {
        return carName + " : " + convertPositionToString();
    }

    public String convertPositionToString() {
        return "-".repeat(position);
    }

    public boolean isEqual(int winnerPosition) {
        return this.position == winnerPosition;
    }

    @Override
    public String toString() {
        return carName.toString();
    }
}
