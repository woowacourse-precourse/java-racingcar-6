package racingcar.model;

import racingcar.validator.model.ModelValidator;

public class CarName {
    private final String name;

    public CarName(String name) {
        this.name = name;

        (new ModelValidator()).validate(this);
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
