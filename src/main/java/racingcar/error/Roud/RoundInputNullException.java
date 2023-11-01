package racingcar.error.Roud;

import racingcar.error.ErrorMessage;

public class RoundInputNullException extends IllegalArgumentException {

    public RoundInputNullException(ErrorMessage message) {
        super(message.getMessage());
    }
}