package racingcar.validation.playtime;

import racingcar.exception.ErrorMessage;
import racingcar.exception.RacingCarException;

public class MinimumPlayTimeValidator implements PlayTimeValidator {
    @Override
    public void validate(String inputValue) {
        if (Integer.parseInt(inputValue) <= 0) {
            throw RacingCarException.of(ErrorMessage.MINIMUM_PLAY_TIME);
        }
    }
}
