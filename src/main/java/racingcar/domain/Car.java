package racingcar.domain;

import static racingcar.enums.RacingConfig.MAX_CAR_NAME_LENGTH;

public class Car {
    private static final String PATTERN = "^(?=.*[A-Za-z])[A-Za-z0-9]+$";
    private final String name;
    private int movedCount;

    public Car(String name) {
        validateLength(name);
        validatePattern(name);
        this.name = name;
        this.movedCount = 0;
    }

    private void validateLength(String name) {
        if (name.isBlank() || name.length() > MAX_CAR_NAME_LENGTH.getValue()) {
            throw new IllegalArgumentException(
                    String.format("rejected value: %s -> 자동차 이름은 1자 이상 %d자 이하만 가능합니다.",
                            name, MAX_CAR_NAME_LENGTH.getValue())
            );
        }
    }

    private void validatePattern(String name) {
        if (!name.matches(PATTERN)) {
            throw new IllegalArgumentException(
                    String.format("rejected value: %s -> 자동차 이름은 영문자 또는 영문자+숫자만 가능합니다.", name)
            );
        }
    }

    public String getName() {
        return name;
    }

    public int getMovedCount() {
        return movedCount;
    }

    public void move() {
        movedCount++;
    }

    public boolean isSameMovedCount(int movedCount) {
        return this.movedCount == movedCount;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Car car) {
            return this.name.equals(car.name);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}
