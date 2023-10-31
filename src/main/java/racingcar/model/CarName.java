package racingcar.model;

import java.util.Objects;
import racingcar.constant.ExceptionMessage;

public class CarName {
    private final String name;

    public CarName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException(ExceptionMessage.CAR_NAME_CANT_NOT_BLANK);
        }
        if (name.length() > 5) {
            throw new IllegalArgumentException(ExceptionMessage.CAR_NAME_IS_TOO_LONG);
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CarName carName = (CarName) o;
        return Objects.equals(name, carName.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
