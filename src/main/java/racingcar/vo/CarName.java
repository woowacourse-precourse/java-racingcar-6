package racingcar.vo;

import java.util.Objects;

public class CarName {

    private final String carName;

    public CarName(String carName) {
        this.carName = carName;
    }

    @Override
    public int hashCode() {
        return Objects.hash(carName);
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }

        CarName other = (CarName) object;
        return this.carName.equals(other.carName);
    }
}
