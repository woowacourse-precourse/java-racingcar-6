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


    public String show() {
        return new String(carName);
    }

    @Override
    public boolean equals(Object obj) {
        CarName other = (CarName) obj;
        return this.carName.equals(other.show());
    }
}
