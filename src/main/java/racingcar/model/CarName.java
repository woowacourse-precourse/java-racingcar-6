package racingcar.model;

import racingcar.validator.model.CarNameValidator;

public class CarName {
    private final String name;

    public CarName(String name) {
        this.name = name;
        CarNameValidator.getInstance().validate(this);
    }

    public String getName() {
        return name;
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof CarName)) {
            return false;
        }
        return name.equals(((CarName) o).getName());
    }

    @Override
    public String toString() {
        return name;
    }
}
