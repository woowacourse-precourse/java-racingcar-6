package racingcar.model;

import java.util.Objects;
import racingcar.constant.RacingGameConstants;
import racingcar.exception.NullException;
import racingcar.exception.car.carName.HasSpaceException;
import racingcar.exception.car.carName.LengthException;

public class CarName {
    private final String name;

    public CarName(String name) {
        validateName(name);
        this.name = name;
    }

    private String getName() {
        return name;
    }

    private void validateName(String name) {
        validateNull(name);
        validateNameLength(name);
        validateNameHasNoSpace(name);
    }

    private void validateNull(String name) {
        if (name == null) {
            throw new NullException();
        }
    }

    private void validateNameLength(String name) {
        if (name.length() < RacingGameConstants.CAR_NAME_LENGTH_MIN
                || name.length() > RacingGameConstants.CAR_NAME_LENGTH_MAX) {
            throw new LengthException();
        }
    }

    private void validateNameHasNoSpace(String name) {
        if (name.contains(" ") || name.contains("\t")) {
            throw new HasSpaceException();
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof CarName)) {
            return false;
        }
        CarName cn = (CarName) o;
        return name.equals(cn.getName());
    }

    @Override
    public String toString() {
        return name;
    }
}
