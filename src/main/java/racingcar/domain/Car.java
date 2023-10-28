package racingcar.domain;

import java.util.Objects;

public class Car {
    private static final int MAX_NAME_LENGTH = 5;
    private final String carName;
    private final CarPosition carPosition;

    public Car(final String carName) {
        validateCarNameLength(carName);
        this.carName = carName;
        this.carPosition= new CarPosition();
    }

    private void validateCarNameLength(final String carName) {
        if (carName.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("자동차 이름은 " + MAX_NAME_LENGTH + "자 이하여야 합니다.");
        }
    }

    public String getPositionAsString() {
        return carName + " : " + carPosition.getPositionAsString();
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car that = (Car) o;
        return Objects.equals(this.carName, that.carName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(carName);
    }
}
