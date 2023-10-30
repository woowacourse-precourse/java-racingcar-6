package racingcar.domain;

import racingcar.exception.CarExceptionMessage;

import java.util.Objects;

import static racingcar.domain.CarSetting.*;
import static racingcar.exception.CarExceptionMessage.*;


public class Car implements Comparable<Car> {
    private final MovingStrategy movingStrategy;
    private final String name;
    private int position;

    public Car(MovingStrategy movingStrategy, String name) {
        validateNameLength(name);
        validateNameBlank(name);
        this.movingStrategy = movingStrategy;
        this.name = name;
        this.position = INIT_POSITION.getSetting();
    }

    public Boolean goForward() {
        Boolean moved = movingStrategy.isCarMove();
        if (moved) {
            this.position++;
        }

        return moved;
    }

    public Boolean isWinner(Integer winnerPosition) {
        return position == winnerPosition;
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return new String(name);
    }
    private void validateNameLength(String name) {
        if (name.length() > MAX_NAME_LENGTH.getSetting()) {
            throw new IllegalArgumentException(ERROR_NAME_LENGTH.getMessage());
        }
    }

    private void validateNameBlank(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException(ERROR_NAME_BLANK.getMessage());
        }
    }

    @Override
    public int compareTo(Car that) {
        return this.position - that.position;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) return true;
        if (that == null || getClass() != that.getClass()) return false;
        Car car = (Car) that;
        return position == car.position && Objects.equals(movingStrategy, car.movingStrategy) && Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(movingStrategy, name, position);
    }
}
