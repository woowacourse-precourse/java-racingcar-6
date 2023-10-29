package racingcar.domain;

import java.util.Objects;

public class CarPosition implements Comparable<CarPosition> {

    private int position = 0;

    public void move(int incrementValue) {
        position = position + incrementValue;
    }

    public int getPosition() {
        return position;
    }

    @Override
    public int compareTo(CarPosition carPosition) {
        return position - carPosition.position;
    }

    @Override
    public boolean equals(Object obj) {
        CarPosition carPosition = (CarPosition) obj;
        return position == carPosition.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }

}
