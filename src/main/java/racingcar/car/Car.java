package racingcar.car;

import java.util.Objects;

public class Car {
    public static final String RESULT_MESSAGE_DELIMITER = " : ";

    private final CarName carName;
    private final Position position;

    public Car(CarName carName, Position position) {
        this.carName = carName;
        this.position = position;
    }

    public String move(MoveNumber number) {
        if (isMovable(number)) {
            position.move();
        }
        return getMoveResult();
    }

    private static boolean isMovable(MoveNumber number) {
        return number.isMovable();
    }

    private String getMoveResult() {
        return carName.getName() + RESULT_MESSAGE_DELIMITER + position.getPositionText();
    }

    public Position getPosition() {
        return position;
    }

    public String getCarName() {
        return carName.getName();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Car carA = (Car) o;
        return Objects.equals(carName, carA.carName) && Objects.equals(position, carA.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(carName, position);
    }

    @Override
    public String toString() {
        return "Car{" +
                "carName=" + carName +
                ", position=" + position +
                '}';
    }
}
