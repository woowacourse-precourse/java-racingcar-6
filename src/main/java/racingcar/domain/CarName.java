package racingcar.domain;

import static racingcar.util.Validator.*;

public class CarName {
    private final String name;

    private CarName(String name) {
        this.name = name;
    }

    public static CarName of(String name) {
        validateEmpty(name);
        validateLength(name);
        return new CarName(name);
    }

    @Override
    public String toString() {
        return this.name;
    }
}
