package racingcar.exception;

import racingcar.exception.errorcode.UserInputErrorCode;

public class UserInputException extends IllegalArgumentException {
    private final UserInputErrorCode errorCode;

    public UserInputException(final UserInputErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }
}
