package racingcar.validator;

import static racingcar.validator.ExceptionMessage.*;

public class InputValidator {
    public static void lessThenFiveLetters(String input){
        // TODO: 상수 교체
        if (input.length() > 5) {
            Exception.illegalArgument(LESS_THEN_FIVE_LETTERS.getMessage());
        }
    }
}
