package racingcar.domain;

import java.util.Objects;

public class Position {

    private int carPosition;

    public Position(int carPosition) {
        this.carPosition = carPosition;
    }

    public void increase() {
        carPosition++;
    }

    public int getCarPosition() {
        return carPosition;
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
