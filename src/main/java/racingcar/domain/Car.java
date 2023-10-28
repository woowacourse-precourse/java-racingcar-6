package racingcar.domain;

public class Car {

    private final Name name;
    private Distance distance;

    private final MoveStrategy moveStrategy;

    public void move(Navigator navigator) {
        distance = moveStrategy.move(distance, navigator);
    }

    public Name getName() {
        return new Name(name.value());
    }

    public Distance getDistance() {
        return new Distance(distance.value());
    }

    public Car(final Name name) {
        this.name = name;
        this.distance = Distance.ZERO;
        this.moveStrategy = new MoveStrategy(MOVING_DISTANCE);
    }

    private static final Distance MOVING_DISTANCE = new Distance(1);
}
