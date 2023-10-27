package racingcar.utill;

import static racingcar.utill.ValidatorConstant.CAR_NAME_MAX_SIZE;

import racingcar.utill.exception.CarNameException;

public class Validator {

    public static void carNameValidation(String carName) {
        if (carName.isEmpty()) {
            throw new CarNameException();
        }
        if (carName.length() > CAR_NAME_MAX_SIZE) {
            throw new CarNameException(carName);
        }
    }
}
