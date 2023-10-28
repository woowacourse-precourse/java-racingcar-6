package Model;

import java.util.Objects;

public class CarPosition {
    private int carPosition;

    public CarPosition(int carPosition) {
        this.carPosition = carPosition;
    }

    public void incrementPosition() {
        carPosition++;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        CarPosition other = (CarPosition) obj;
        return carPosition == other.carPosition;
    }

    @Override
    public int hashCode() {
        return Objects.hash();
    }
}
