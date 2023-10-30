package racingcar.model;

import racingcar.enums.Common;
import racingcar.utils.RandomGenerator;

public class Car {
    private static final String DISTANCE_MARK = "-";
    private String name;
    private final StringBuilder distance;

    public Car(String name) {
        this.name = name;
        this.distance = new StringBuilder();
    }

    public String getName() {
        return name;
    }

    public String getDistance() {
        return distance.toString();
    }

    public void moveForward() {
        RandomGenerator randomGenerator = new RandomGenerator();
        if (randomGenerator.generateRandomNumber(Common.MIN_NUMBER.getIntValue(), Common.MAX_NUMBER.getIntValue()) >= Common.STANDARD_NUMBER.getIntValue())
            distance.append(DISTANCE_MARK);
    }
}
