package racingcar.domain;

import java.util.Objects;

public class Car implements Comparable<Car> {

    private static final String NAME_DELIMITER = " : ";
    private static final String POSITION_REGEX = "-";
    private static final String NAME_RANGE_EXCEPTION_MESSAGE = " 이름은 5자 이하만 가능합니다.";
    private static final int NAME_MAX_LENGTH = 5;
    private static final int NAME_MIN_LENGTH = 1;
    private static final int MOVABLE_THRESHOLD = 3;

    private int position;
    private final String name;

    public Car(String name, int position) {
        validateLengthOf(name);
        this.name = name;
        this.position = position;
    }

    public static Car of(String name, int position) {
        return new Car(name, position);
    }

    private void validateLengthOf(String name) {
        if (name.length() > NAME_MAX_LENGTH || name.length() < NAME_MIN_LENGTH) {
            throw new IllegalArgumentException(NAME_RANGE_EXCEPTION_MESSAGE);
        }
    }

    public void move(int randomNumber) {
        if (randomNumber > MOVABLE_THRESHOLD) {
            this.position++;
        }
    }

    public String getName() {
        return name;
    }

    public boolean isSamePosition(Car otherCar) {
        return this.position == otherCar.position;
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
        return position == car.position && Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(position, name);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(name);
        sb.append(NAME_DELIMITER);
        sb.append(POSITION_REGEX.repeat(Math.max(0, position)));
        return sb.toString();
    }

    @Override
    public int compareTo(Car otherCar) {
        return this.position - otherCar.position;
    }

}
