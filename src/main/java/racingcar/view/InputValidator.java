package racingcar.view;

import racingcar.global.message.ErrorMessage;

import java.util.List;
import java.util.regex.Pattern;

public class InputValidator {

    private static final int MAX_LENGTH_OF_CAR_NAME = 5;

    public static void isInputValid(String userInput){
        if (userInput == null || userInput.equals(" ") || userInput.isEmpty())
            throw new IllegalArgumentException(ErrorMessage.INPUT_IS_INVALID.getMessage());
    }

    public static void isFiveLettersOver(String userInput){
        if (userInput.length() > MAX_LENGTH_OF_CAR_NAME)
            throw new IllegalArgumentException(ErrorMessage.INPUT_OVER_MAX_LEN.getMessage());
    }

    public static void isInputDigit(String userInput){
        if(!Pattern.matches("^[0-9]*$",userInput))
            throw new IllegalArgumentException(ErrorMessage.INPUT_IS_NOT_NUMBER.getMessage());
    }


    public static <E> void isListEmpty(List<E> list){
        if(list.isEmpty())
            throw new IllegalArgumentException(ErrorMessage.INPUT_IS_INVALID.getMessage());
    }
}
