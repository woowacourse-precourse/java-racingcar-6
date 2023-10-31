package racingcar.model;

import static racingcar.util.Constant.MAX_CAR_NAME_LENGTH;

import racingcar.exception.car_name.InValidNameLengthException;

public class Name {

    private final String name;

    public Name(final String name) {
        validateName(name);
        this.name = name;
    }

    private void validateName(final String name) {
        if (isInvalidLength(name)) {
            throw new InValidNameLengthException(name);
        }
    }

    private boolean isInvalidLength(final String name) {
        return name.length() > MAX_CAR_NAME_LENGTH.getValue();
    }

    public String getName() {
        return name;
    }
}
