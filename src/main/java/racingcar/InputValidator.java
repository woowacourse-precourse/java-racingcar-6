package racingcar;

import racingcar.constants.ErrorMessage;
import racingcar.constants.InputPattern;
import racingcar.exception.DivisionCarNamesException;

public class InputValidator {

    private InputValidator() {
    }

    public static void validateDivisionCarNames(String carNames) {
        if (InputPattern.isNotMatchCarNamesPattern(carNames)) {
            throw new DivisionCarNamesException(ErrorMessage.DIVISION_CAR_NAME_ERROR.getMessage());
        }
    }
}
