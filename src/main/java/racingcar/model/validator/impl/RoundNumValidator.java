package racingcar.model.validator.impl;

import racingcar.constants.GameInfo;
import racingcar.constants.Messages;
import racingcar.model.validator.CommonValidator;
import racingcar.model.validator.InputValidator;

public class RoundNumValidator implements InputValidator {

    private final int roundNum;

    public RoundNumValidator(String roundNum) {
        this.roundNum = Integer.parseInt(validate(roundNum));
    }

    @Override
    public String validate(String roundNum) {
        if (!CommonValidator.validateIsNumeric(roundNum)) {
            throw new IllegalArgumentException(Messages.ERROR_ROUND_NUM_NUMERIC.getMessage());
        }
        if (!CommonValidator.validateRoundNumRange(roundNum)) {
            throw new IllegalArgumentException(Messages.ERROR_ROUND_NUM_RANGE.getMessage());
        }
        return roundNum;
    }

    @Override
    public Object getValidatedInput() {
        return this.roundNum;
    }
}
