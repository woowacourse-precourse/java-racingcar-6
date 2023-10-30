package racingcar.model;

import racingcar.util.Constants;
import racingcar.util.RandomDistanceGenerator;

public class Car {
    private final Name name;
    private final Position position;

    public Car(Name name, Position position) {
        this.name = name;
        this.position = position;
    }

    public void go() {
        int randomDistance = RandomDistanceGenerator.generateDistance();
        this.position.validatePosition(randomDistance);
    }

    public String positionToString() {
        return name.getName()
                + Constants.OUTPUT_FORMAT.constant
                + position.getStringPosition();
    }

}
