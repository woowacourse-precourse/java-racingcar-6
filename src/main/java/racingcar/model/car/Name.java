package racingcar.model.car;

import racingcar.constant.RacingGameConstants;
import racingcar.exception.NullException;
import racingcar.exception.car.name.LengthException;

public class Name {
    private String name;
    public Name(String name) {
        validate(name);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    private void validate(String name) {
        validateNull(name);
        validateNameLength(name);
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
}
