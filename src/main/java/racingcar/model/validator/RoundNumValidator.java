package racingcar.model.validator;

import racingcar.constants.GameInfo;
import racingcar.constants.Messages;

// TODO
// - Validator 추상화
public class RoundNumValidator {
    private final int roundNum;

    public RoundNumValidator(String roundNum) {
        this.roundNum = Integer.parseInt(validate(roundNum));
    }

    public int getRoundNum() {
        return roundNum;
    }

    public String validate(String roundNum) {
        if (!roundNum.matches(GameInfo.ROUND_NUM_REGEX)) {
            throw new IllegalArgumentException(Messages.INPUT_ROUND_NUM_ERROR.getMessage());
        }
        return roundNum;
    }
}
