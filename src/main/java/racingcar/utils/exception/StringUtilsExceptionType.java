package racingcar.utils.exception;

import racingcar.common.MessageType;

public enum StringUtilsExceptionType implements MessageType {
    OUT_OF_RANGE("Out Of Range Exception"),
    NOT_NUMERIC("Is Not Numeric"),
    NOT_SAME_LENGTH("Is Not Same Length"),
    ;

    private final String message;

    StringUtilsExceptionType(final String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return this.message;
    }
}
