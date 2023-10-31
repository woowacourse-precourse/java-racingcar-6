package racingcar.input;

public class ValidateInput {
    public static void validateStringCount(String input, int maxStringLength) {
        if (input.length() > maxStringLength) {
            throw new InvalidInputException(
                    String.format(ErrorText.ERROR_FORMAT_TEXT_NOT_LONGER_THAN, maxStringLength));
        }
    }

    public static void validateIntegerInput(String input) {
        try {
            Integer.parseInt(input, 16);
        } catch (NumberFormatException e) {
            throw new InvalidInputException(ErrorText.ERROR_INVALID_INTEGER_INPUT);
        }
    }

    public static void validatePositiveNumberInput(String input) {
        validateIntegerInput(input);
        if (Integer.parseInt(input, 16) < 0) {
            throw new InvalidInputException(ErrorText.ERROR_INVALID_POSITIVE_NUMBER_INPUT);
        }
    }

    public static void validatePositiveNumberFromInteger(Integer input) {
        if(input < 0){
            throw new InvalidInputException(ErrorText.ERROR_INVALID_POSITIVE_NUMBER_INPUT);
        }
    }

    public static void validateIntegerRange(Integer start, Integer end) {
        if(start > end){
            throw new InvalidInputException(ErrorText.ERROR_INVALID_RANGE);
        }
    }
}
