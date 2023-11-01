package racingcar.exception;

import java.io.Serializable;

public class CustomException extends RuntimeException implements Serializable {
    private ErrorCode errorCode;

    public CustomException(ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }
}
