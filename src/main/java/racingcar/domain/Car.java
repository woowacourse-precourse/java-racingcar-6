package racingcar.domain;

public class Car {
    private static final int STANDARD_VALUE = 4;

    private final Name name;
    private final Position position;

    public Car(String name) {
        this.name = new Name(name);
        this.position = new Position();
    }

    public void move(int randomNumber) {
        if (randomNumber >= STANDARD_VALUE) {
            position.move();
        }
    }

    public Name getName() {
        return name;
    }

    public Position getPosition() {
        return position;
    }
}
