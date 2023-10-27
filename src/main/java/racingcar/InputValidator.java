package racingcar;

import racingcar.constants.ErrorMessage;
import racingcar.constants.InputPattern;
import racingcar.exception.DivisionCarNamesError;

public class InputValidator {

    private InputValidator() {
    }

    public static void validateDivisionCarNames(String carNames) {
        if (InputPattern.isNotMatchCarNamesPattern(carNames)) {
            throw new DivisionCarNamesError(ErrorMessage.DIVISION_CAR_NAME_ERROR.getMessage());
        }
    }
}
