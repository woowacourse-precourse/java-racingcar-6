package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private final String name;

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
    }
}
