package racingcar.domain;

import racingcar.validate.RacingCarValidate;

public class Car implements Racing {
    private String name;
    private int straightCount;

    public Car(String name) {
        RacingCarValidate.validateCarName(name);
        this.name = name;
        this.straightCount = 0;
    }

    public String getName() {
        return name;
    }

    public int getStraightCount() {
        return straightCount;
    }

    public void moveStraight() {
        straightCount++;
    }
}
