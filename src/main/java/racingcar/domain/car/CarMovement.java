package racingcar.domain.car;

import java.util.Objects;

public class CarMovement implements Comparable<CarMovement> {

    private static final int INITIAL_VALUE = 0;
    private static final String DASH = "-";

    private int movement;

    public CarMovement() {
        this.movement = INITIAL_VALUE;
    }

    public void goForward() {
        movement += 1;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < movement; i++) {
            stringBuilder.append(DASH);
        }
        return stringBuilder.toString();
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
