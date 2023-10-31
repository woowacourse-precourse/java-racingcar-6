package racingcar.validator;

import static racingcar.validator.ExceptionMessage.*;
import static racingcar.validator.constants.ValidatorConstants.*;

public class InputValidator {
    public static void lessThenFiveLetters(String input){
        if (input.length() > MAX_LENGTH_OF_CAR_NAME.getValue()) {
            Exception.illegalArgument(LESS_THEN_FIVE_LETTERS.getMessage());
        }
    }
}
