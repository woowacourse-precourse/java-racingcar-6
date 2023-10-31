package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Objects;

import static racingcar.config.GameConfig.INITIAL_DISTANCE;
import static racingcar.config.GameConfig.MAX_RANDOM_VALUE;
import static racingcar.config.GameConfig.MIN_RANDOM_VALUE;
import static racingcar.config.GameConfig.MIN_TO_MOVING_FORWARD;

public class Car implements Comparable<Car> {
    private final String name;
    private int distance;

    public Car(final String name) {
        this.name = name;
        this.distance = INITIAL_DISTANCE;
    }

    public void move() {
        final int randomNumber = createRandomNumber();
        if (randomNumber >= MIN_TO_MOVING_FORWARD) {
            distance++;
        }
    }

    private int createRandomNumber() {
        return Randoms.pickNumberInRange(MIN_RANDOM_VALUE, MAX_RANDOM_VALUE);
    }

    public String getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }

    @Override
    public int compareTo(final Car other) {
        return Integer.compare(this.distance, other.distance);
    }

    @Override
    public boolean equals(final Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || getClass() != other.getClass()) {
            return false;
        }

        final Car car = (Car) other;
        return Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
