package racingcar.model;

public class Car {

    private static final int MIN_FORWARD_SPEED = 4;

    private final CarName name;

    private final CarPosition position;

    private Car(final CarName name, final CarPosition position) {
        this.name = name;
        this.position = position;
    }

    public static Car withName(final String name) {
        return new Car(CarName.valueOf(name), CarPosition.withZero());
    }

    public void moveForward(final int speed) {
        if (speed >= MIN_FORWARD_SPEED) {
            position.moveForward();
        }
    }

    public String getName() {
        return name.getName();
    }

    public int getPosition() {
        return position.getPosition();
    }
}
