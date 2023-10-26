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

    public boolean isRunnable() {
        final int START_INCLUSIVE = 1;
        final int END_INCLUSIVE = 9;
        final int CONDITION_FOR_RUNNABLE = 4;

        final int randomNumber = Randoms.pickNumberInRange(START_INCLUSIVE, END_INCLUSIVE);
        return randomNumber >= CONDITION_FOR_RUNNABLE;
    }
}
