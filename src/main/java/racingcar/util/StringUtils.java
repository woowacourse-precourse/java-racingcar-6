package racingcar.util;

import static java.util.stream.Collectors.joining;

import java.util.Arrays;
import java.util.List;

public class StringUtils {

    public static List<String> toCarNameList(String input) {
        String[] nameArray = input.split(",");
        return Arrays.asList(nameArray);
    }

    public static int toInteger(String input) {
        return Integer.parseInt(input);
    }

    public static String listToString(List<String> input) {
        String result = input.stream()
                .collect(joining(", "));
        return result;
    }
}
