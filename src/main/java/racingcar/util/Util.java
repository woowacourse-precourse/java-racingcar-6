package racingcar.util;

import java.util.Arrays;
import java.util.List;

public class Util {
    public static List<String> splitNameByComma(String names) {
        return Arrays
                .stream(removeSpaceAll(names).split(","))
                .toList();
    }

    public static String removeSpaceAll(String names) {
        return names.replaceAll("\\s", "");
    }

    public static int convertStringToInt(String count) {
        try {
            int convert = Integer.parseInt(count);
            return convert;
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_ATTEMPT_COUNT_FORMAT.getMessage());
        }
    }

    public static boolean isEqual(int num1, int num2) {
        return num1 == num2;
    }
}

