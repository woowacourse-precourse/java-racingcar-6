package racingcar.util.validator.proxy;

import racingcar.util.validator.carName.CarNameValidator;
import racingcar.util.validator.raceCount.RaceCountValidator;

import static racingcar.container.ApplicationContainer.getCarNameValidator;
import static racingcar.container.ApplicationContainer.getRaceCountValidator;

public class ValidatorProxy implements InputValidator {
    private CarNameValidator carNameValidator = null;
    private RaceCountValidator raceCountValidator = null;

    @Override
    public boolean validateName(String input) {
        if (carNameValidator == null) {
            carNameValidator = getCarNameValidator();
        }
        return carNameValidator.validateName(input);
    }

    @Override
    public boolean validateRaceCount(String input) {
        if (raceCountValidator == null) {
            raceCountValidator = getRaceCountValidator();
        }
        return raceCountValidator.validateRaceCount(input);
    }
}
