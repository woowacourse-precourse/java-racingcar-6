package racingcar.domain;

import java.util.Objects;

public class CarName {

    private final String name;

    public CarName(String carName) {
        validateCarNameLength(carName);
        validateBlank(carName);
        this.name = carName;
    }

    private void validateCarNameLength(String carName) {
        if (carName.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
        }
    }

    private void validateBlank(String carName) {
        if (carName.isBlank()) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
        }
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

    public String getName() {
        return name;
    }

}
