package racingcar.domain;

public class Car {

    private static final int MOVE_CONDITION = 4;

    private final Name name;
    private final Position position;

    public Car(final String name) {
        this.name = new Name(name);
        this.position = new Position();
    }

    public void move(final int randomNumber) {
        if (randomNumber >= MOVE_CONDITION) {
            position.moveForward();
        }
    }

    public boolean isSamePosition(final Car car) {
        return this.position.equals(car.position);
    }

    public String getName() {
        return name.getName();
    }

    public int getPosition() {
        return position.getPosition();
    }

}
