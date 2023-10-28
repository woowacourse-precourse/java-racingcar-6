package racingcar.util.validator.proxy;

import racingcar.util.validator.carName.CarNameValidator;
import racingcar.util.validator.raceCount.RaceCountValidator;

public class ValidatorProxy implements InputValidator {
    public ValidatorProxy(CarNameValidator carNameValidator, RaceCountValidator raceCountValidator) {
        this.carNameValidator = carNameValidator;
        this.raceCountValidator = raceCountValidator;
    }

    private final CarNameValidator carNameValidator;
    private final RaceCountValidator raceCountValidator;

    private final int STRING_LENGTH = 1;

    @Override
    @Deprecated
    public boolean validate(String input) {
        return defaultValidate(input);
    }

    @Override
    public CarNameValidator carName() {
        return carNameValidator;
    }

    @Override
    public RaceCountValidator raceCount() {
        return raceCountValidator;
    }

    private boolean defaultValidate(String input) {
        if ( input.length() == STRING_LENGTH )
            return raceCountValidator.validate(input);
        return carNameValidator.validate(input);
    }
}
