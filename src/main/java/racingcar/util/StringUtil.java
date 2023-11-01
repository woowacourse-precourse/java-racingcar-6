package racingcar.util;

import java.util.Arrays;
import java.util.List;

public class StringUtil {
    public static List<String> splitByDelimiter(String input, String delimiter) {
        try {
            String[] splitedData = input.split(delimiter);
            return Arrays.asList(splitedData);
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }

    public static void checkMaxLengthLimit(String input, Integer threshold) {
        if (input.length() > threshold) {
            throw new IllegalArgumentException();
        }
    }

    public static Integer convertToNumber(String input) {
        try {
            return Integer.parseInt(input);
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }
}
