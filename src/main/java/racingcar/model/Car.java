package racingcar.model;

import racingcar.dto.CarDto;

import java.util.Objects;

public class Car {
    private static final Integer INIT_POSITION = 0;
    private static final Integer MOVE_STANDARD = 4;

    private final String name;
    private Integer position;

    public Car(String name) {
        this.name = name;
        this.position = INIT_POSITION;
    }

    public void go(Integer value) {
        if (MOVE_STANDARD <= value) {
            position++;
        }
    }

    public int comparePosition(Car compareCar) {
        return this.position - compareCar.position;
    }

    public CarDto toDto() {
        return new CarDto(name, position);
    }

    public Integer getPosition() {
        return position;
    }

    public String getName() {
        return name;
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
        return Objects.hash(getPosition());
    }
}
