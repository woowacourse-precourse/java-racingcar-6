package racingcar.model;

import racingcar.dto.CarState;

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

    public CarState getCarState() {
        return new CarState(getNameValue(), getForwardState());
    }

    private String getForwardState() {
        return position.getForwardState();
    }

    public int getPosition() {
        return position.getPosition();
    }
}
