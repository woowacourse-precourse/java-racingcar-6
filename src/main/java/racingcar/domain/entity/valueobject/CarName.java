package racingcar.domain.entity.valueobject;

import racingcar.domain.util.validator.CarNameValidator;

public class CarName {
    private String name;

    public CarName(String name) {
        CarNameValidator.validate(name);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || getClass() != other.getClass()) {
            return false;
        }

        CarName carName = (CarName) other;

        return name.equals(carName.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}
