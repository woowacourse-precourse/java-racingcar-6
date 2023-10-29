package racingcar;

import java.util.Arrays;

public class ValidateInput {
    private final static int MAX_NAME_LENGTH = 5;


    public static void isRightInput(String input) throws IllegalStateException {
        if (input.isBlank()) {
            throw new IllegalStateException();
        }
    }


    public static void isRightCarNames(String[] names) throws IllegalStateException {

        if (isCarNameDuplicate(names)) {
            throw new IllegalStateException();
        }

        if (isWrongLengthNames(names)) {
            throw new IllegalStateException();
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
