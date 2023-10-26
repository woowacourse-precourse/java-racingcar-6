package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

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
}
