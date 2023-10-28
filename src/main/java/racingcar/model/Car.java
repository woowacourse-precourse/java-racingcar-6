package racingcar.model;

import racingcar.dto.CurrentResult;

public class Car {
    private final Name name;
    private final Position position;

    public Car(Name name, Position position) {
        this.name = name;
        this.position = position;
    }

    public String getNameValue() {
        return name.getName();
    }

    public void attemptForward() {
        position.attemptForward();
    }

    public CurrentResult createCurrentResult() {
        return new CurrentResult(name.getName(), position.getForwardState());
    }

    public int getPosition() {
        return position.getPosition();
    }
}
