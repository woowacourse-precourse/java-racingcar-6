package racingcar.domain.car;

import java.util.Objects;

public class Car implements Comparable<Car> {

    private static final int MAX_CAR_NAME_LENGTH = 5;
    private static final int MIN_NUMBER_TO_MOVE = 4;

    private final String name;
    private int position;

    public Car(String name) {
        this.validateCarName(name);
        this.name = name;
    }

    private void validateCarName(String name) {
        this.validateNameInMaxLength(name);
        this.validateNameIsEmpty(name);
    }

    private void validateNameIsEmpty(String name) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException("차 이름은 비어있을 수 없음");
        }
    }

    private void validateNameInMaxLength(String name) {
        if (name.length() > MAX_CAR_NAME_LENGTH) {
            throw new IllegalArgumentException("차 이름은 5자 까지만 허용됨");
        }
    }

    public void tryToMove(int number) {
        if (number >= MIN_NUMBER_TO_MOVE) {
            this.position += 1;
        }
    }

    public boolean isSamePosition(Car other) {
        return this.position == other.position;
    }

    public String getName() {
        return this.name;
    }

    public CarDto getStatus() {
        return new CarDto(this.name, this.position);
    }

    @Override
    public int compareTo(Car other) {
        return this.position - other.position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car other = (Car) o;
        return position == other.position && Objects.equals(name, other.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, position);
    }
}
