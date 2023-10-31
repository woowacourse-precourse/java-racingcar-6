package racingcar.utils;

import racingcar.enums.Common;

public class CommonValidator {
    public static boolean isOverMaxLength(String input) {
        return input.length() > Common.NAME_MAX_LENGTH.getIntValue();
    }

    public static boolean isNumeric(String input) {
        try {
            Integer.valueOf(input);
            return true;
        } catch (NumberFormatException nfe) {
            return false;
        }
    }

    public static boolean isPositive(int input) {
        return input > 0;
    }

    public static boolean isPositive(String input) {
        try {
            int number = Integer.valueOf(input);
            return isPositive(number);
        } catch (NumberFormatException nfe) {
            return false;
        }
    }
}
