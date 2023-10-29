package racingcar.util;

public class ValidationNumber {

    private ValidationNumber() {}

    private static final String removeNumberRegex = "[0-9]";

    public static void validateAttemptNumber(String attemptNumber) {
        validateIsEmpty(attemptNumber);
        validateIsNumber(attemptNumber);
    }

    public static void validateIsEmpty(String attemptNumber) {
        attemptNumber = attemptNumber.trim();
        if (attemptNumber.isEmpty()) {
            throw new IllegalArgumentException(ExceptionMessages.EMPTY.getExceptionMessage());
        }
    }

    public static void validateIsNumber(String attemptNumber) {
        String removedNumberString = attemptNumber.replaceAll(removeNumberRegex, "");
        if (removedNumberString.isEmpty() == false) {
            throw new IllegalArgumentException(ExceptionMessages.NOT_NUMBER.getExceptionMessage());
        }
    }
}
