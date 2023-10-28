package racingcar.util;

import java.util.Arrays;
import java.util.regex.Pattern;

public class Validator {
    private static final String REGEXP_POSITIVE_INTEGER = "^[1-9]\\d*$";
    public static void getValidatedCarName(String input) {
        if (isEmptyValue(input)) {
            throw new IllegalArgumentException(ExceptionMessage.EMPTY_VALUE.getMessage());
        }
        if (validateLength(input)) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_LENGTH.getMessage());
        }
        if (!isUniqueName(input)) {
            throw new IllegalArgumentException(ExceptionMessage.DUPLICATED.getMessage());
        }
    }

    public static void getValidatedAttemptCount(String input){
        if (!isPositiveInteger(input))
            throw new IllegalArgumentException(ExceptionMessage.NOT_POSITIVE_INTEGER.getMessage());
    }


    private static boolean isPositiveInteger(String input){
        return Pattern.matches(REGEXP_POSITIVE_INTEGER, input);
    }

    private static boolean isUniqueName(String input) {
        long uniqueNameCount = Arrays.stream(input.split(","))
                .distinct()
                .count();
        long nameCount = Arrays.stream(input.split(","))
                .count();
        return uniqueNameCount == nameCount;
    }

    private static boolean isEmptyValue(String input) {
        return input == null || input.isBlank();
    }

    private static boolean validateLength(String input) {
        return Arrays.stream(input.split(","))
                .anyMatch(name -> name.length() > NumberConst.NAME_LENGTH);
    }


}
