package racingcar.domain.car;

import java.util.Objects;

public class CarPosition {

    private int position = 0;

    public void move(int incrementValue) {
        position = position + incrementValue;
    }

    public int getPosition() {
        return position;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        CarPosition carPosition = (CarPosition) obj;
        return position == carPosition.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }

}
