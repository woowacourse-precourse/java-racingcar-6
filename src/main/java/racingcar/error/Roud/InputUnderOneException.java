package racingcar.error.Roud;

import racingcar.error.ErrorMessage;

public class InputUnderOneException extends IllegalArgumentException {

    public InputUnderOneException(ErrorMessage message) {
        super(message.getMessage());
    }
}