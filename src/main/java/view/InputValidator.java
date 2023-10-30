package view;

import global.message.ErrorMessage;

public class InputValidator {

    private static final int MAX_LENGTH_OF_CAR_NAME = 5;

    public static void isInputValid(String userInput){

        if (userInput == null || userInput.isBlank())
            throw new IllegalArgumentException(ErrorMessage.INPUT_IS_INVALID.getMessage());
    }

    public static void isFiveLettersOver(String userInput){

        if (userInput.length() > MAX_LENGTH_OF_CAR_NAME)
            throw new IllegalArgumentException(ErrorMessage.INPUT_OVER_MAX_LEN.getMessage());
    }

    public static void isInputDigit(String userInput){

        if (!userInput.matches("\\d+"))
            throw new IllegalArgumentException(ErrorMessage.INPUT_IS_NOT_NUMBER.getMessage());
    }

}
