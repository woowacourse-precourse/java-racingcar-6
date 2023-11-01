package racingcar.domain;

public class Car {

    private static final String MOVEMENT = "-";

    private final Name name;
    private final Position position;

    public Car(Name name) {
        this.name = name;
        this.position = Position.initial();
    }

    public void move() {
        this.position.move();
    }

    public String getName() {
        return name.name();
    }

    public int getPosition() {
        return this.position.getPosition();
    }

    @Override
    public String toString() {
        return MOVEMENT.repeat(this.getPosition());
    }
}
