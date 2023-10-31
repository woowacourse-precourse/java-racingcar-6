package Model;

import java.util.Objects;

public class CarName {
    private String carName;

    public CarName(String carName) {
        this.carName = carName;
    }

    public boolean isUnder5Characters() {
        return carName.length() <= 5;
    }

    public boolean isEmpty() {
        return carName.isEmpty();
    }

    public String getCarName() {
        return carName;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        CarName other = (CarName) obj;
        return carName.equals(other.carName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(carName);
    }
}
