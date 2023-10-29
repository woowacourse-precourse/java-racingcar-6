package racingcar.domain;

import racingcar.utils.Constants;

public class Car {
    private Name name;
    private Position position;

    public Car(String name) {
        this.name = new Name(name);
        this.position = new Position(Constants.START_POSITION);
    }

}
