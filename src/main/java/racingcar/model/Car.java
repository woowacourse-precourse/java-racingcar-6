package racingcar.model;

import racingcar.util.IntGenerator;

public class Car {
    private static final int MAXIMUM_NAME_LENGTH = 5;
    private static final int ONE_STEP = 1;
    private static final int MINIMUM_FORWARD_CONDITION = 4;
    private final String name;
    private final IntGenerator intGenerator;
    private int forwardCount;

    public Car(String name, IntGenerator intGenerator) {
        checkNameLength(name);
        this.name = name;
        this.intGenerator = intGenerator;
        this.forwardCount = 0;
    }

    public void tryForward() {
        if (canForward()) {
            this.forwardCount += ONE_STEP;
        }
    }

    private boolean canForward() {
        int pickedNumber = intGenerator.pickNumber();
        return pickedNumber >= MINIMUM_FORWARD_CONDITION;
    }

    private void checkNameLength(String name) {
        if (name.length() > MAXIMUM_NAME_LENGTH) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하여야 합니다.");
        }
    }

    public CarState summarizeCurrentState() {
        return new CarState(this.name, this.forwardCount);
    }
}
