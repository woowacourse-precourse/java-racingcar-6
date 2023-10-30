package racingcar.model;

import static racingcar.util.Constant.MAX_CAR_NAME_LENGTH;

import racingcar.exception.car_name.NotValidNameLengthException;

public class Name {

    private final String name;

    public Name(final String name) {
        validateName(name);
        this.name = name;
    }

    private void validateName(final String name) {
        if (!isNameLengthValid(name)) {
            throw new NotValidNameLengthException(name);
        }
    }

    private boolean isNameLengthValid(final String name) {
        return name.length() <= MAX_CAR_NAME_LENGTH.getValue();
    }

    public String getName() {
        return name;
    }
}
