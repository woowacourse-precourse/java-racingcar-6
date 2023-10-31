package racingcar.validation.playtime;

import racingcar.exception.ErrorMessage;
import racingcar.exception.RacingCarException;

public class IntegerTypeValidator implements PlayTimeValidator {
    @Override
    public void validate(String inputValue) {
        try {
            Integer.valueOf(inputValue);
        } catch (Exception e) {
            throw RacingCarException.of(ErrorMessage.INVALID_TYPE);
        }
    }
}
