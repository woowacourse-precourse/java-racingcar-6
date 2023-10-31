package racingcar.game.validator;

import static racingcar.game.validator.ExceptionMessage.*;
import static racingcar.game.validator.constants.ValidatorConstants.*;

public class InputValidator {
    public static void lessThenFiveLetters(String input){
        if (input.length() > MAX_LENGTH_OF_CAR_NAME.getValue()) {
            Exception.illegalArgument(LESS_THEN_FIVE_LETTERS.getMessage());
        }
    }
}
