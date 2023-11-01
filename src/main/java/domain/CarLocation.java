package domain;

import java.util.Objects;

public class CarLocation {

    private int carLocation;

    public CarLocation(int carLocation) {
        this.carLocation = carLocation;
    }


    public void increaseValue(int moveRatio) {
        this.carLocation += moveRatio;
    }

    public int getValue() {
        return carLocation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CarLocation location = (CarLocation) o;
        return this.carLocation == location.carLocation;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(carLocation);
    }


}
