package racingcar.validation.playtime;

import racingcar.exception.ErrorMessage;
import racingcar.exception.RacingCarException;

public class EmptyPlayTimeValidator implements PlayTimeValidator {
    @Override
    public void validate(String inputValue) {
        if (inputValue.isEmpty()) {
            throw RacingCarException.of(ErrorMessage.EMPTY_INPUT);
        }
    }
}
