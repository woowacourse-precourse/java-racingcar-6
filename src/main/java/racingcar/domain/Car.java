package racingcar.domain;

import static racingcar.domain.enums.Constants.MAX_NAME_LENGTH;
import static racingcar.domain.enums.Constants.MIN_MOVE_THRESHOLD;
import static racingcar.domain.enums.Constants.RANDOM_END_RANGE;
import static racingcar.domain.enums.Constants.RANDOM_START_RANGE;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Objects;

public class Car {
    private static final String BLANK = "";
    private String name;
    private int moveCount;

    public Car(String name, int position) {
        validataeNameBlank(name);
        validateNameLength(name);
        this.name = name;
        this.moveCount = position;
    }

    public Car(String name) {
        this(name, 0);
    }

    private void validataeNameBlank(String name) {
        if (BLANK.equals(name) || name.isBlank()) {
            throw new IllegalArgumentException();
        }
    }

    private void validateNameLength(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException();
        }
    }

    public void moveWithRandomNumber() {
        int num = Randoms.pickNumberInRange(RANDOM_START_RANGE, RANDOM_END_RANGE);
        if (num >= MIN_MOVE_THRESHOLD) {
            move();
        }
    }

    public void move() {
        this.moveCount++;
    }

    public String getName() {
        return name;
    }

    public int getMoveCount() {
        return moveCount;
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
        return Objects.hash(name, moveCount);
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", position=" + moveCount +
                '}';
    }
}
