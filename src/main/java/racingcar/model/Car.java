package racingcar.model;

import java.util.Objects;
import racingcar.util.NullValidator;

public final class Car {
    private static final String NULL_NAME_EXCEPTION_MESSAGE = "자동차 이름은 null 될 수 없습니다.";
    private static final String NULL_POSITION_EXCEPTION_MESSAGE = "자동차 위치는 null 될 수 없습니다.";

    private final CarName name;
    private final CarPosition position;

    Car(CarName name, CarPosition position) {
        validateNull(name, position);
        this.name = name;
        this.position = position;
    }

    private void validateNull(CarName name, CarPosition position) {
        NullValidator.checkNotNull(name, NULL_NAME_EXCEPTION_MESSAGE);
        NullValidator.checkNotNull(position, NULL_POSITION_EXCEPTION_MESSAGE);
    }

    public static Car from(String carName) {
        CarName name = CarName.from(carName);
        CarPosition startPosition = CarPosition.initialPosition();
        return new Car(name, startPosition);
    }

    public Car move(MovementCondition movementCondition) {
        if (movementCondition.isMovable()) {
            CarPosition movedPosition = position.move();
            return new Car(name, movedPosition);
        }
        return new Car(name, position);
    }

    public boolean isSamePosition(CarPosition maxPosition) {
        return position.equals(maxPosition);
    }

    public CarName getName() {
        return name;
    }

    public CarPosition getPosition() {
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
        return Objects.equals(name, car.name) && Objects.equals(position, car.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, position);
    }
}
