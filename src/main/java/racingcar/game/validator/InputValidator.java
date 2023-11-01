package racingcar.game.validator;

import java.util.regex.Pattern;

import static racingcar.game.validator.ExceptionMessage.*;
import static racingcar.game.validator.constants.ValidatorIntegerConstants.*;
import static racingcar.game.validator.constants.ValidatorStringConstants.*;

public class InputValidator {
    public static void lessThenFiveLetters(String input){
        if (input.length() > MAX_LENGTH_OF_CAR_NAME.getValue()) {
            Exception.illegalArgument(LESS_THEN_FIVE_LETTERS.getMessage());
        }
    }

    public static void inputMustBeInteger(String input){
        if (Pattern.matches(INTEGER_REGULAR_EXPRESSION.getValue(), input)) return;
        Exception.illegalArgument(VALUE_MUST_BE_INTEGER.getMessage());
    }

    public static void inputMustHaveValue(String input){
        if (input == null) {
            Exception.illegalArgument(NULL_VALUE.getMessage());
        }
    }
}
