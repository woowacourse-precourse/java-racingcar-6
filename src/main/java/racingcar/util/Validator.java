package racingcar.util;

import java.util.Arrays;

public class Validator {

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
