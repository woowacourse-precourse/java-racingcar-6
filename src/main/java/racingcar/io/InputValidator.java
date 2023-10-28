package racingcar.io;

import racingcar.constants.ErrorMessage;
import racingcar.constants.InputPattern;
import racingcar.exception.DivisionCarNamesException;
import racingcar.exception.InputNumericException;

public class InputValidator {

    private InputValidator() {
    }

    public static void validateDivisionCarNames(String carNames) {
        if (InputPattern.isNotMatchCarNamesPattern(carNames)) {
            throw new DivisionCarNamesException(ErrorMessage.DIVISION_CAR_NAME_ERROR.getMessage());
        }
    }

    public static void validateNumeric(String attemptCount) {
        if (InputPattern.isNotNumeric(attemptCount)) {
            throw new InputNumericException(ErrorMessage.INPUT_NUMERIC_ERROR.getMessage());
        }
    }
}
