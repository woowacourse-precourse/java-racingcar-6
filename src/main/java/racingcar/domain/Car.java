package racingcar.domain;

import java.util.Objects;
import racingcar.strategy.MoveStrategy;

public class Car implements Comparable<Car> {
    private static final int INITIAL_STEP = 0;

    private final Name name;
    private int step;
    private final MoveStrategy moveStrategy;

    private Car(Name name, MoveStrategy moveStrategy) {
        this.name = name;
        this.step = INITIAL_STEP;
        this.moveStrategy = moveStrategy;
    }

    public static Car of(Name name, MoveStrategy moveStrategy) {
        return new Car(name, moveStrategy);
    }

    public void attemptMove() {
        boolean canMove = moveStrategy.shouldMove();
        
        if (canMove) {
            moveForward();
        }
    }

    private void moveForward() {
        step++;
    }

    public Name getName() {
        return name;
    }

    public int getStep() {
        return step;
    }

    @Override
    public int compareTo(Car car) {
        return Integer.compare(this.step, car.step);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Car car = (Car) o;
        return step == car.step;
    }

    @Override
    public int hashCode() {
        return Objects.hash(step);
    }
}
