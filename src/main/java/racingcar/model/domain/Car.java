package racingcar.model.domain;

import java.util.Map;

public class Car {
    private Map<String, Integer> car;
    private int attemptNumber;

    public Car() {
    }

    public void setName(Map<String, Integer> car) {
        this.car = car;
    }

    public void setAttemptNumber(int numberOfAttempts) {
        this.attemptNumber = numberOfAttempts;
    }

    public Map<String, Integer> getName() {
        return this.car;
    }

    public int getAttemptNumber() {
        return this.attemptNumber;
    }
}

