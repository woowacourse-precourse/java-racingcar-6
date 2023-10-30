package racingcar.model;

import racingcar.enums.Common;
import racingcar.utils.NumberGenerator;
import racingcar.utils.RandomGenerator;
import racingcar.utils.Validator;

public class Car {
    private static final String DISTANCE_MARK = "-";
    private final String name;
    private final StringBuilder distance;

    public Car(String name) {
        Validator.validateCarNameInput(name);
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
        NumberGenerator randomGenerator = new RandomGenerator();
        int randomNumber = randomGenerator.generateNumber(Common.MIN_NUMBER.getIntValue(), Common.MAX_NUMBER.getIntValue());
        if (randomNumber >= Common.STANDARD_NUMBER.getIntValue())
            distance.append(DISTANCE_MARK);
    }
}
