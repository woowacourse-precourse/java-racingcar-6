package racingcar.util;

public class ClientValidator extends Validator {

    public static final int LEAST_NATURAL_NUMBER = 1;

    public static int getValidatedIntValue(String inputtedStringTryNumber) {
        int validatedValue = validateCastToInt(inputtedStringTryNumber);
        validateNaturalNumber(validatedValue);
        return validatedValue;
    }

    private static int validateCastToInt(String inputtedString) {
        int value = 0;
        try {
            value = Integer.parseInt(inputtedString);
        } catch (NumberFormatException e) {
            throwIllegalArgumentException(Error.NOT_NUMBER_INPUTTED.getMessage());
        }
        return value;
    }

    private static void validateNaturalNumber(int value) {
        if (value < LEAST_NATURAL_NUMBER) {
            throwIllegalArgumentException(Error.NOT_NATURAL_NUMBER.getMessage());
        }
    }
}