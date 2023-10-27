package racingcar.model;

import racingcar.util.RandomUtil;

public class Car {
    private final String name;
    private final Integer forwards;

    public Car(String name) {
        this.name = name;
        this.forwards = 0;
    }

    private int createRandomeNumer() {
        return RandomUtil.createRandomNumberInRange(0, 9);
    }
}
