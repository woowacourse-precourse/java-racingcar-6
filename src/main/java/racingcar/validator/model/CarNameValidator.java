package racingcar.validator.model;

import racingcar.constant.RacingGameConstants;
import racingcar.exception.NullException;
import racingcar.exception.car.name.HasBlankException;
import racingcar.exception.car.name.LengthException;
import racingcar.model.CarName;

public class CarNameValidator extends ModelValidator {
    @Override
    public void validate(Object target) {
        CarName carName = (CarName) target;
        validateName(carName.getName());
    }

    private void validateName(String name) {
        validateNull(name);
        validateNameLength(name);
        validateNoBlanks(name);
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

    private void validateNoBlanks(String name) {
        if (name.contains(" ") || name.contains("\t") || name.contains("\n")) {
            throw new HasBlankException();
        }
    }
}
