package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.stream.IntStream;

public class Car {
    private final String name;
    private int distance = 0;

    public Car(final String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean canMoveForward() {
        final int START_INCLUSIVE = 1;
        final int END_INCLUSIVE = 9;
        final int CONDITION_MOVING_FORWARD = 4;

        final int randomNumber = Randoms.pickNumberInRange(START_INCLUSIVE, END_INCLUSIVE);
        return randomNumber >= CONDITION_MOVING_FORWARD;
    }

    public boolean canStop() {
        return !canMoveForward();
    }

    public void moveForward() {
        if (canStop()) {
            return;
        }

        distance++;
    }

    public int getDistance() {
        return distance;
    }

    public String getDistanceString() {
        final String STRING_ONE_DISTANCE = "-";
        final StringBuilder builder = new StringBuilder(distance);

        IntStream.rangeClosed(1, distance)
                .forEach(value -> builder.append(STRING_ONE_DISTANCE));

        return builder.toString();
    }

    @Override
    public boolean equals(final Object other) {
        if (other == null) {
            return false;
        }

        if (this == other) {
            return true;
        }

        if (getClass() != other.getClass()) {
            return false;
        }

        Car otherCar = (Car) other;
        return name.equals(otherCar.name);
    }
}
