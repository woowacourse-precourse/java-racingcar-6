package racingcar.model;

import racingcar.dto.CarDto;

import java.util.Objects;

public class Car implements Comparable<Car> {
    private static final Integer INITIAL_POSITION = 0;

    private final String name;
    private Integer position;

    public Car(String name) {
        CarValidator.validate(name);
        this.name = name;
        this.position = INITIAL_POSITION;
    }

    public void go(boolean canMove) {
        if (canMove) {
            position++;
        }
    }

    public CarDto toDto() {
        return new CarDto(name, position);
    }

    public String getName() {
        return name;
    }

    public Integer getPosition() {
        return position;
    }

    @Override
    public int compareTo(Car o) {
        return this.position - o.position;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Car otherCar = (Car) obj;
        return this.position.equals(otherCar.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }

}
