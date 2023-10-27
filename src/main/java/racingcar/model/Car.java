package racingcar.model;

import racingcar.util.RandomUtil;

public class Car {
    private static final int MIN_RANDOM_NUMBER = 0;
    private static final int MAX_RANDOM_NUMBER = 9;

    private final String name;
    private final Integer forwards;

    public Car(String name) {
        this.name = name;
        this.forwards = 0;
    }

    private int createRandomeNumer() {
        return RandomUtil.createRandomNumberInRange(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER);
    }
}
