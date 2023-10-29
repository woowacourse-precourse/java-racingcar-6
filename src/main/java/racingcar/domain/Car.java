package racingcar.domain;

import racingcar.util.RandomNumber;
import racingcar.util.RandomNumber.MoveOrder;

public class Car implements Comparable<Car> {
    private final String name;
    private int distance;
    private static final String BASH = "-";

    public Car(String name) {
        this.name = name;
        distance = 0;
    }

    public void updateDistance() {
        if (RandomNumber.getMoveOrder() == MoveOrder.MOVE_FORWARD) {
            distance += 1;
        }
    }

    public int getDistance() {
        return distance;
    }

    public String getName() {
        return name;
    }

    @Override
    public int compareTo(Car other) {
        return this.distance - other.distance;
    }

    @Override
    public String toString() {
        return name + " : " + BASH.repeat(distance);
    }
}
