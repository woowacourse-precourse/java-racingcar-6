package racingcar.validator;

import racingcar.exception.IllegalNameEmptyException;
import racingcar.exception.IllegalNameLengthException;

public class InputValidator {
    private static final Integer LIMIT_NAME_LENGTH = 5;
    public static void validateNameLength(String carName){
        if (carName.length() > LIMIT_NAME_LENGTH) throw new IllegalNameLengthException();
    }
    public static void validateCarNamesIsEmpty(String[] carNames){
        if (carNames.length == 0) throw new IllegalNameEmptyException();
    }
}
