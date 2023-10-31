package racingcar.model.validator.impl;

import racingcar.constants.GameInfo;
import racingcar.constants.Messages;
import racingcar.model.validator.InputValidator;

// TODO
// - Validator 추상화
public class RoundNumValidator implements InputValidator {
    private final int roundNum;

    public RoundNumValidator(String roundNum) {
        this.roundNum = Integer.parseInt(validate(roundNum));
    }
    @Override
    public String validate(String roundNum) {
        if (!roundNum.matches(GameInfo.ROUND_NUM_REGEX)) {
            throw new IllegalArgumentException(Messages.INPUT_ROUND_NUM_ERROR.getMessage());
        }
        return roundNum;
    }

    @Override
    public Object getValidatedInput() {
        return this.roundNum;
    }
}
