package racingcar.util.validator.proxy;

import racingcar.util.validator.name.NameValidator;
import racingcar.util.validator.raceCount.RaceCountValidator;

import static racingcar.container.ApplicationContainer.getNameValidator;
import static racingcar.container.ApplicationContainer.getRaceCountValidator;

public class ValidatorDecorator implements InputValidator {
    private NameValidator nameValidator = null;
    private RaceCountValidator raceCountValidator = null;

    @Override
    public boolean validateName(String input) {
        if (nameValidator == null) {
            nameValidator = getNameValidator();
        }
        return nameValidator.validateName(input);
    }

    @Override
    public boolean validateRaceCount(String input) {
        if (raceCountValidator == null) {
            raceCountValidator = getRaceCountValidator();
        }
        return raceCountValidator.validateRaceCount(input);
    }
}
