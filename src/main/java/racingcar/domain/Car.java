package racingcar.domain;

import static racingcar.domain.enums.Constants.MAX_NAME_LENGTH;
import static racingcar.domain.enums.Constants.MIN_MOVE_THRESHOLD;
import static racingcar.domain.enums.Error.INVALID_NAME_BLANK;
import static racingcar.domain.enums.Error.INVALID_NAME_LENGTH;

import java.util.Objects;
import racingcar.util.ErrorException;

public class Car {
    private static final String BLANK = "";
    private String name;
    private int position;

    public Car(String name, int position) {
        validataeNameBlank(name);
        validateNameLength(name);
        this.name = name;
        this.position = position;
    }

    public Car(String name) {
        this(name, 0);
    }

    private void validataeNameBlank(String name) {
        if (BLANK.equals(name) || name.isBlank()) {
            throw new ErrorException(INVALID_NAME_BLANK);
        }
    }

    private void validateNameLength(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new ErrorException(INVALID_NAME_LENGTH);
        }
    }

    public void move(int number) {
        if (isMovable(number)) {
            position++;
        }
    }

    private boolean isMovable(int number) {
        return number >= MIN_MOVE_THRESHOLD;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
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
        return Objects.hash(name, position);
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", position=" + position +
                '}';
    }
}
