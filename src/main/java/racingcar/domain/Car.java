package racingcar.domain;

import static racingcar.enums.Constant.MAX_NAME_LENGTH;

import java.util.Objects;

public class Car implements Comparable<Car> {

    private int position;
    private final String name;

    public Car(String name) {
        this.name = name;
    }

    public void moveForward() {
        position += 1;
    }

    public boolean isExceedMaxLength() {
        if (name.length() > MAX_NAME_LENGTH.getConstant()) {
            return true;
        }
        return false;
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
        return name.equals(car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public int compareTo(Car car) {
        return car.position - this.position;
    }

    public boolean isSamePosition(Car car) {
        return this.position == car.position;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

}
