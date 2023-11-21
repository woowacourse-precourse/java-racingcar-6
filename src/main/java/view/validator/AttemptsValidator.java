package view.validator;

import util.exception.ExceptionMessage;

public class AttemptsValidator {
    public static int validate(String input){
        validateBlank(input);
        validateDigit(input);
        return convertStringToInt(input);
    }

    private static void validateBlank(String input) {
        if (input == null || input.isBlank()) {
            ExceptionMessage.INPUT_ATTEMPTS_EMPTY.throwException();
        }
    }

    private static void validateDigit(String input){
        if (!input.matches("\\d+")) {
            ExceptionMessage.INPUT_ATTEMPTS_EMPTY.throwException();
        }
    }

    private static int convertStringToInt(String input){
        return Integer.parseInt(input);
    }
}
