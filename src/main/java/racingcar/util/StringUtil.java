package racingcar.util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringUtil {
    public static String deleteAllSpaces(String input) {
        return input.replace(" ", "");
    }

    public static List<String> parseListseperatedByComma(String input) {
        return Arrays.stream(input.split(","))
                .collect(Collectors.toList());
    }
}
