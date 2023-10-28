package racingcar.util.validator.proxy;

import racingcar.util.validator.carName.CarNameValidator;
import racingcar.util.validator.raceCount.RaceCountValidator;

import static racingcar.container.ApplicationContainer.getCarNameValidator;
import static racingcar.container.ApplicationContainer.getRaceCountValidator;

public class ValidatorProxy implements InputValidator {
    private CarNameValidator carNameValidator = null;
    private RaceCountValidator raceCountValidator = null;

    private final int STRING_LENGTH = 1;

    @Override
    @Deprecated
    public boolean validate(String input) {
        return defaultValidate(input);
    }

    @Override
    public CarNameValidator carName() {
        if (carNameValidator == null) {
            carNameValidator = getCarNameValidator();
        }
        return carNameValidator;
    }

    @Override
    public RaceCountValidator raceCount() {
        if (raceCountValidator == null) {
            raceCountValidator = getRaceCountValidator();
        }
        return raceCountValidator;
    }

    private boolean defaultValidate(String input) {
        if (input.length() == STRING_LENGTH)
            return raceCountValidator.validate(input);
        return carNameValidator.validate(input);
    }
}
