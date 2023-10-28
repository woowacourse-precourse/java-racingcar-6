package racingcar.validate;

import racingcar.global.GameConfig;
import racingcar.global.exception.CarGameException;
import racingcar.global.exception.ErrorMessage;

public abstract class InputValidator {
    private static boolean isEmpty(final String input){
        return input.isEmpty();
    }

    private static boolean isValidLength(final String name){
        return name.length() <= GameConfig.MAX_CAR_NAME_LENGTH;
    }

    private static boolean isNumber(final String number){
        return number
                .chars()
                .allMatch(Character::isDigit);
    }

    public static void validateEmptyInput(final String input){
        if(isEmpty(input)){
            throw CarGameException.of(ErrorMessage.EMPTY_VALUE);
        }
    }

    public static void validateNameLength(final String name){
        if(!isValidLength(name))
            throw CarGameException.of(ErrorMessage.INVALID_LENGTH);
    }

    public static void validateNumberInput(final String number){
        if(!isNumber(number))
            throw CarGameException.of(ErrorMessage.NOT_A_NUMBER);
    }
}
