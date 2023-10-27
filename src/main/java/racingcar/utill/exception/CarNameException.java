package racingcar.utill.exception;

import static racingcar.utill.exception.ExceptionConstant.CAR_NAME_BLANK_EXCEPTION_MESSAGE;
import static racingcar.utill.exception.ExceptionConstant.CAR_NAME_EXCEPTION_MESSAGE;

public class CarNameException extends IllegalArgumentException {
    public CarNameException() {
        super(CAR_NAME_BLANK_EXCEPTION_MESSAGE);
    }

    public CarNameException(String carName) {
        super("%s는 %s".formatted(carName, CAR_NAME_EXCEPTION_MESSAGE));
    }


}
