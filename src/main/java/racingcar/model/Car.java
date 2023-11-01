package racingcar.model;

import racingcar.exception.ErrorCode;
import racingcar.model.intgenerator.IntGenerator;
import racingcar.model.intgenerator.RandomIntGenerator;

public class Car {
    private static final int MAXIMUM_NAME_LENGTH = 5;
    private static final int ONE_STEP = 1;
    private static final int MINIMUM_FORWARD_CONDITION = 4;
    private final String name;
    private final IntGenerator intGenerator;
    private int forwardCount;

    public Car(String name) {
        this(name, new RandomIntGenerator());
    }

    public Car(String name, IntGenerator intGenerator) {
        validateNameLength(name);
        this.name = name;
        this.intGenerator = intGenerator;
        this.forwardCount = 0;
    }

    public String getName() {
        return this.name;
    }

    public int getForwardCount() {
        return this.forwardCount;
    }

    public boolean hasForwardCountOf(int targetForwardCount) {
        return this.forwardCount == targetForwardCount;
    }

    public CarState summarizeState() {
        return new CarState(this.name, this.forwardCount);
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

    private void validateNameLength(String name) {
        if (name.length() > MAXIMUM_NAME_LENGTH) {
            throw new IllegalArgumentException(ErrorCode.INVALID_NAME_LENGTH.getMessage());
        }
    }
}
