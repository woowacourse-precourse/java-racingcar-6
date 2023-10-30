package racingcar.domain;

import java.util.Objects;

public class Car {
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
        if (name.length() > 5 || name.length() < 1) {
            throw new IllegalArgumentException("이름은 5자 이하만 가능합니다.");
        }
    }

    public void move(int randomNumber) {
        if (randomNumber > 3) {
            this.position++;
        }
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
}
