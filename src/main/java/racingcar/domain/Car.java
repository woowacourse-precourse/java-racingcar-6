package racingcar.domain;

import java.util.Objects;

public class Car {

    private static final int MAX_NAME_LENGTH = 5;
    private static final int DIVISION_NUMBER = 4;

    private final String name;
    private int position;

    public Car(String name) {
        validateNameLength(name);
        this.name = name;
    }

    public void move(int number) {
        if (judgeNumber(number)) {
            position++;
        }
    }

    private boolean judgeNumber(int number) {
        return number >= DIVISION_NUMBER;
    }

    public boolean isSamePosition(int maxPosition) {
        return this.position == maxPosition;
    }

    public int comparePosition(int maxPosition) {
        return Math.max(maxPosition, position);
    }

    private void validateNameLength(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("자동차 이름 길이의 범위를 벗어났습니다.");
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
        return Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
