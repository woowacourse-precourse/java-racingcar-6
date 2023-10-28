package racingcar.common.exception;

import racingcar.common.response.ErrorCode;

public class CustomErrorException extends IllegalArgumentException {

    public CustomErrorException(ErrorCode e) {
        super(e.getMessage());
    }
}
