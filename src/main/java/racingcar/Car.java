package racingcar;

import java.util.Objects;

public class Car {
    private String name;
    private Integer position;

    private Car(String name, Integer position) {
        this.name = name;
        this.position = position;
    }

    public static Car of(String name) {
        validateCarName(name);
        return new Car(name, 0);
    }

    private static void validateCarName(String name) {
        if (name.isEmpty() || name.length() > 5) {
            throw new IllegalArgumentException();
        }
    }

    public void move() {
        position++;
    }

    public String getName() {
        return name;
    }

    public Integer getPosition() {
        return position;
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
}
