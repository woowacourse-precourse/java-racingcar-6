package racingcar.validator;

import racingcar.exception.IllegalNameEmptyException;
import racingcar.exception.IllegalNameLengthException;
import racingcar.exception.IllegalRepeatNumberException;
import racingcar.exception.IllegalRepeatNumberSignException;

public class InputValidator {
    private static final Integer LIMIT_NAME_LENGTH = 5;
    public static void validateNameLength(String carName){
        if (carName.length() > LIMIT_NAME_LENGTH) throw new IllegalNameLengthException();
    }
    public static void validateCarNamesIsEmpty(String[] carNames){
        if (carNames.length == 0) throw new IllegalNameEmptyException();
    }
    public static Integer validateRepeatNumberIsNumber(String repeatNumber){
        try {
            Integer.parseInt(repeatNumber);
        } catch (NumberFormatException e) {
            throw new IllegalRepeatNumberException();
        }
        return Integer.parseInt(repeatNumber);
    }

    public static void validateRepeatNumberSign(Integer repeatNumber){
        if (repeatNumber <= 0) throw new IllegalRepeatNumberSignException();
    }
}
