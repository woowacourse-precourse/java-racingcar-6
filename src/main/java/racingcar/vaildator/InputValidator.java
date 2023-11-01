package racingcar.vaildator;

import static racingcar.Constant.*;

public class InputValidator {

    public static void validateNotBlankInput(String input){
        if(input.trim().isBlank()) throw new IllegalArgumentException(BLANK_INPUT_EXCEPTION_MESSAGE);
    }

    public static int validateNotNumericNumber(String input) {
        try{
            return Integer.parseInt(input);
        }catch (NumberFormatException e){
            throw new IllegalArgumentException(IS_NOT_POSITIVE_INTEGER);
        }
    }

    public static void validatePositiveNumber(int round){
        if(round <= 0) throw new IllegalArgumentException(IS_NOT_POSITIVE_INTEGER);
    }

    public static void validateCarNameLength(String carName){
        if(carName.length() < MINIMUM_NAME_LENGTH || carName.length() > MAXIMUM_NAME_LENGTH){
            throw new IllegalArgumentException(NAME_LENGTH_ERROR);
        }
    }

}
