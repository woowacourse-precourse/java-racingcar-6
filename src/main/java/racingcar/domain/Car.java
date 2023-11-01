package racingcar.domain;

import java.util.Objects;

public class Car {
    public static final int MAX_NAME_LENGTH = 5;
    public static final int STANDARD_MOVING_CAR = 4;

    private String name;
    private int distance;

    public Car(String name) {
        validateName(name);
        this.name = name;
        this.distance = 0;
    }

    private void validateName(String name) {
        validateBlank(name);
        validateLength(name);
    }

    private void validateBlank(String name) {
        if (name.isBlank()) {
            throw new IllegalArgumentException("내용이 없는 빈 자동차 이름은 사용할 수 없습니다.");
        }
    }

    private void validateLength(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하여야 합니다.");
        }
    }

    public void tryToMove(MovingStrategy strategy) {
        if (isMovable(strategy)) {
            move();
        }
    }

    private static boolean isMovable(MovingStrategy strategy) {
        return strategy.generateValue() >= STANDARD_MOVING_CAR;
    }

    private void move() {
        distance++;
    }

    public int getDistance() {
        return distance;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Car car)) return false;

        return Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }
}
