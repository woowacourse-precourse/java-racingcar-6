package racingcar.car;

import racingcar.constants.Constants;

public class Car {
    private final String name;
    private int stepCount;

    public Car(String name) {
        validateLength(name);
        this.name = name;
        this.stepCount = 0;
    }

    private void validateLength(String name) {
        if (name.length() > Constants.MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("이름이 " + Constants.MAX_NAME_LENGTH + "자 이상입니다");
        }
    }

    public String getName() {
        return name;
    }

    public int getStepCount() {
        return stepCount;
    }

    public void increaseStepCount() {
        stepCount++;
    }
}
