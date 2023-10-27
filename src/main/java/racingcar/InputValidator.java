package racingcar;

import racingcar.constants.ErrorMessage;
import racingcar.exception.DivisionCarNamesError;

public class InputValidator {

    private static final String DIVISION = ",";

    private InputValidator() {}

    public static void validateDivisionCarNames(String carNames){
        if (!carNames.contains(DIVISION)){
            throw new DivisionCarNamesError(ErrorMessage.DIVISION_CAR_NAME_ERROR.getMessage());
        }
    }
}
