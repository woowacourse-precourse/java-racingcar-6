package view;

import constants.Constants;
import constants.ExceptionMessage;

public class AttemptTimesValidator {
    public void validate(String input){
        validateInteger(input);
        int validatedInteger = Integer.parseInt(input);
        validatePlus(validatedInteger);
    }

    private void validateInteger(String input) {
        try {
            Integer.parseInt(input);
        } catch (Exception e) {
            throw new IllegalArgumentException(ExceptionMessage.NOT_INTEGER);
        }
    }

    private void validatePlus(int input) {
        if (input < 0) {
            throw new IllegalArgumentException(ExceptionMessage.NOT_PLUS);
        }
    }
}
