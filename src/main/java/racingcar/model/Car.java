package racingcar.model;

import racingcar.dto.CarResult;

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

    public CarResult getCarState() {
        return new CarResult(getNameValue(), getForwardState());
    }

    private String getForwardState() {
        return position.getForwardState();
    }

    public int getPosition() {
        return position.getPosition();
    }
}
