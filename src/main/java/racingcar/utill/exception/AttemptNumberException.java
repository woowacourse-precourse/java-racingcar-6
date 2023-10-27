package racingcar.utill.exception;

import static racingcar.utill.exception.ExceptionConstant.CAR_NAME_EXCEPTION_MESSAGE;

public class AttemptNumberException extends IllegalArgumentException {
    public AttemptNumberException(String attemptNumber) {
        super("%s는 %s".formatted(attemptNumber, CAR_NAME_EXCEPTION_MESSAGE));
    }
}
