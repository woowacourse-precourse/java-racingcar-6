package racingcar.model;

import racingcar.enums.Constants;
import racingcar.enums.Exceptions;
import racingcar.exception.CarNameLengthException;

public class Name {
    private String name;

    public Name(String name) {
        validateNameLength(name);
        this.name = name;
    }

    private void validateNameLength(String name) {
        if (isLengthOver5(name)) {
            throw new CarNameLengthException(Exceptions.CAR_NAME_IS_OVER_5.getMessage());
        }

        if (name.isBlank()) {
            throw new CarNameLengthException(Exceptions.CAR_NAME_IS_BLANK.getMessage());
        }
    }

    private boolean isLengthOver5(String name) {
        if (name.length() > Constants.NAME_LENGTH.getNumber()) {
            return true;
        }
        return false;
    }
}
