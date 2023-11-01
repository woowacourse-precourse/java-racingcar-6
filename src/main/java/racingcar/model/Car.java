package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.stream.IntStream;

public class Car {
    private static final int LIMIT_NAME_SIZE = 5;
    private static final int START_INCLUSIVE = 1;
    private static final int END_INCLUSIVE = 9;
    private static final int CONDITION_MOVING_FORWARD = 4;
    private static final String STRING_ONE_DISTANCE = "-";
    private static final String DELIMETER_BETWEEN_NAME_DISTANCE_STRING = " : ";
    private final String name;
    private int distance = 0;

    public Car(final String name) {
        this.name = name;
        validateNameSize();
    }

    private void validateNameSize() {
        if (name.length() <= LIMIT_NAME_SIZE) {
            return;
        }

        throw new IllegalArgumentException("Car 객체의 name 속성은 " + LIMIT_NAME_SIZE + "자 이하만 가능합니다.");
    }

    public String getName() {
        return name;
    }

    public boolean canMoveForward() {
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

    @Override
    public String toString() {
        return name + DELIMETER_BETWEEN_NAME_DISTANCE_STRING + getDistanceString();
    }
}
