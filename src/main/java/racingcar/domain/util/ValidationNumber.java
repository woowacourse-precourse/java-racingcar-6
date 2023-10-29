package racingcar.domain.util;

public class ValidationNumber {

    public static void validateIsEmpty(String attemptNumber) {
        attemptNumber = attemptNumber.trim();
        if (attemptNumber.isEmpty()) {
            throw new IllegalArgumentException(ExceptionMessages.EMPTY.getExceptionMessage());
        }
    }
}
