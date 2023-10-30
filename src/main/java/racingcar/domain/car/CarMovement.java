package racingcar.domain.car;

import java.util.Objects;

public class CarMovement implements Comparable<CarMovement> {

    private static final int INITIAL_VALUE = 0;

    private int movement;

    public CarMovement() {
        this.movement = INITIAL_VALUE;
    }

    public void goForward() {
        movement += 1;
    }

    public int movement() {
        return movement;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof CarMovement)) {
            return false;
        }

        CarMovement carMovement = (CarMovement) object;
        return movement == carMovement.movement;
    }

    @Override
    public int hashCode() {
        return Objects.hash(movement);
    }

    @Override
    public int compareTo(CarMovement movement) {
        return this.movement - movement.movement;
    }
}
