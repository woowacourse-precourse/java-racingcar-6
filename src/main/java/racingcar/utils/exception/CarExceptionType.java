package racingcar.utils.exception;

import racingcar.common.MessageType;

public enum CarExceptionType implements MessageType {
    INPUT_NULL("Enter Null Or Empty Input"),
    DUPLICATE("Enter Duplicate Input"),
    INVALID_LENGTH("Enter Invalid Length"),
    NOT_NUMERIC("Enter Not Numeric Input")
    ;


    private final String message;

    CarExceptionType(final String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return this.message;
    }
}
