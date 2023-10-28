package racingcar.util.validator.proxy;

import racingcar.util.validator.Name.NameValidator;
import racingcar.util.validator.raceCount.RaceCountValidator;

import static racingcar.container.ApplicationContainer.getNameValidator;
import static racingcar.container.ApplicationContainer.getRaceCountValidator;

public class ValidatorProxy implements InputValidator {
    private NameValidator NameValidator = null;
    private RaceCountValidator raceCountValidator = null;

    @Override
    public boolean validateName(String input) {
        if (NameValidator == null) {
            NameValidator = getNameValidator();
        }
        return NameValidator.validateName(input);
    }

    @Override
    public boolean validateRaceCount(String input) {
        if (raceCountValidator == null) {
            raceCountValidator = getRaceCountValidator();
        }
        return raceCountValidator.validateRaceCount(input);
    }
}
