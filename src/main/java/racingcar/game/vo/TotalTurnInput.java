package racingcar.game.vo;

import racingcar.common.config.RacingCarRule;
import racingcar.validator.Validator;

public record TotalTurnInput(String input) {

    public TotalTurnInput {
        Validator.validateLength(input, RacingCarRule.TOTAL_TURN_INPUT_LENGTH);
        Validator.validateHasText(input);
        Validator.validateNumeric(input);
    }

    public int toInt() {
        return Integer.parseInt(input);
    }
}
