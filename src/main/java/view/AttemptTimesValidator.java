package view;

import constants.Constants;
import constants.ExceptionMessage;

public class AttemptTimesValidator {
    public void validate(String input){
        int validatedInteger = validateInteger(input);
        validatePlus(validatedInteger);
    }

    private int validateInteger(String input) {
        try {
            return Integer.parseInt(input);
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
