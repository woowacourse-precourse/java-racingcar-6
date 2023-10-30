package racingcar.domain;

import java.util.Objects;

public class CarName {

    private final String name;

    public CarName(String carName) {
        this.name = carName;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        CarName carName = (CarName) object;
        return Objects.equals(name, carName.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

}
