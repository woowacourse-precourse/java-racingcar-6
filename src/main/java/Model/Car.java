package Model;

import java.util.Objects;

public class Car {
    private CarName carName;
    private CarPosition carPosition;

    public Car(String name) {
        carName = new CarName(name);
        carPosition = new CarPosition(0);
    }

    public void moveForward() {
        carPosition.incrementPosition();
    }

    public boolean isNameValid() {
        if (carName.isEmpty()) {
            return false;
        }
        if (!carName.isUnder5Characters()) {
            return false;
        }
        return true;
    }

    public String getName() {
        return carName.getCarName();
    }

    public int getPosition() {
        return carPosition.getCarPosition();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Car other = (Car) obj;
        return carName.equals(other.carName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(carName);
    }
}
