package racingcar.domain;

public class Car {

    private final Name name;
    private final Position position;

    public Car(Name name) {
        this.name = name;
        this.position = Position.setStartPosition();
    }

    public void goForward() {
        this.position.move();
    }

    public String getName() {
        return name.value();
    }

    public int getPosition() {
        return position.getValue();
    }
}
