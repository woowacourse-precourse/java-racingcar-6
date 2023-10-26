package racingcar.domain;

import racingcar.utils.Constants;

import java.util.Objects;

public class Car implements Comparable<Car> {
    private static final int INITIAL_POSITION = 0;
    private static final int MIN_NUMBER_TO_MOVE = 4;

    private final Name name;
    private final Position position;

    Car(String name, int position) {
        this.name = new Name(name);
        this.position = new Position(position);
    }

    public Car(String name) {
        this(name, INITIAL_POSITION);
    }

    public void moveOrStop(int number) {
        validateNumber(number);

        if (number >= MIN_NUMBER_TO_MOVE) {
            position.increase();
        }
    }

    private void validateNumber(int number) {
        if (number < Constants.MIN_NUMBER_RANGE || number > Constants.MAX_NUMBER_RANGE) {
            throw new IllegalArgumentException("잘못된 입력 값입니다.");
        }
    }

    public boolean isSamePosition(Car car) {
        return car.isMatchPosition(position);
    }

    private boolean isMatchPosition(Position position) {
        return this.position.equals(position);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(name, car.name) && Objects.equals(position, car.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, position);
    }

    @Override
    public int compareTo(Car other) {
        return position.compareTo(other.position);
    }
}
