package racingcar.domain;

import java.util.Objects;

public class Position {

    private static final String CAR_POSITION = "-";
    private static final int MIN_VALUE = 0;
    private int carPosition;

    public Position(int carPosition) {
        this.carPosition = carPosition;
    }

    public void increasePosition() {
        carPosition++;
    }

    public int getCarPosition() {
        return carPosition;
    }

    public StringBuilder countPositionToString(StringBuilder stringBuilder) {
        return stringBuilder.append(CAR_POSITION.repeat(Math.max(MIN_VALUE, carPosition)));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Position position = (Position) o;
        return carPosition == position.carPosition;
    }

    @Override
    public int hashCode(){
        return Objects.hash(carPosition);
    }
}
