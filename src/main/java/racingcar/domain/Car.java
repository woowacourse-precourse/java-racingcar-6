package racingcar.domain;

import static racingcar.domain.constant.GameValueConstant.CAR_INIT_DISTANCE;
import static racingcar.domain.constant.GameValueConstant.CAR_NAME_MAX_LENGTH;
import static racingcar.domain.constant.GameValueConstant.MOVE_OR_STOP_BOUNDARY;
import static racingcar.domain.constant.GameValueConstant.RANDOM_VALUE_UPPER_LIMIT;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import racingcar.domain.exception.DomainConstraintsException;
import racingcar.domain.exception.DomainConstraintsExceptionMessage;
import racingcar.domain.util.RandomNumberGenerator;

public class Car implements Comparable<Car> {
    private final String name;
    private int distance;

    private Car(String name) {
        this.name = name;
        this.distance = CAR_INIT_DISTANCE.getValue();
    }

    public static Car from(String name) {
        validate(name);
        return new Car(name);
    }

    private static void validate(String name) {
        validateIsLengthUpperLimit(name);
    }

    private static void validateIsLengthUpperLimit(String name) {
        if (name.length() > CAR_NAME_MAX_LENGTH.getValue()) {
            throw DomainConstraintsException.of(
                    DomainConstraintsExceptionMessage.CAR_NAME_LENGTH_EXCEEDS_LIMIT.getMessage());
        }
    }

    public void playOneTurn() {
        if (isMoveCondition()) {
            move();
        }
    }

    private boolean isMoveCondition() {
        int randomValue = RandomNumberGenerator.generate();
        return randomValue >= MOVE_OR_STOP_BOUNDARY.getValue()
                && randomValue <= RANDOM_VALUE_UPPER_LIMIT.getValue();
    }

    private void move() {
        distance++;
    }

    public Map<String, Integer> getNameWithDistance() {
        Map<String, Integer> nameWithDistance = new HashMap<>();
        nameWithDistance.put(name, distance);
        return nameWithDistance;
    }

    public String getName() {
        return name;
    }

    public boolean isSameDistance(Car car) {
        return distance == car.distance;
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
        return Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public int compareTo(Car other) {
        return this.distance - other.distance;
    }
}