package racingcar;

import java.util.Arrays;

public class ValidateInput {
    private final static int MAX_NAME_LENGTH = 5;


    public static void isNotNullOrEmpty(String input) throws IllegalArgumentException {
        if (input == null) {
            throw new IllegalArgumentException();
        }

        if (input.isBlank()) {
            throw new IllegalArgumentException();
        }
    }


    public static void isNumeric(String input) throws IllegalArgumentException {
        if (input.matches("^[0-9]*$")) {
            return;
        }
        throw new IllegalArgumentException();
    }


    public static void isRightCarNames(String[] names) throws IllegalArgumentException {

        if (isCarNameDuplicate(names)) {
            throw new IllegalArgumentException();
        }

        if (isWrongLengthNames(names)) {
            throw new IllegalArgumentException();
        }
    }

    private static boolean isCarNameDuplicate(String[] names) {
        Long nonDuplicate = Arrays.stream(names).distinct().count();
        int nonDuplicateSize = Long.valueOf(nonDuplicate).intValue();

        return nonDuplicateSize != names.length;
    }

    private static boolean isWrongLengthNames(String[] names) {
        for (String name : names) {
            if (name.length() > MAX_NAME_LENGTH) {
                return true;
            }
        }
        return false;
    }
}
