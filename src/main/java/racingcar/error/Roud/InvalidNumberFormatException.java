package racingcar.error.Roud;

import racingcar.error.ErrorMessage;

public class InvalidNumberFormatException extends IllegalArgumentException {

    public InvalidNumberFormatException(ErrorMessage message) {
        super(message.getMessage());
    }
}