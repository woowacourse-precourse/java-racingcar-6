package racingcar.domain;

public class Car {
    private static final int MOVE_THRESHOLD = 4;

    private final CarName name;
    private Position position;

    public Car(final String name) {
        this.name = CarName.from(name);
        this.position = Position.init();
    }

    public void moveForward(final int fuel) {
        if (canMove(fuel)) {
            this.position = position.moveForward();
        }
    }

    private static boolean canMove(final int fuel) {
        return fuel >= MOVE_THRESHOLD;
    }

    public Position getPosition() {
        return position;
    }
}
