package racingcar.util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Utils {
    public static List<String> splitString(String string) {
        return Arrays.stream(string.split(","))
                .toList();
    }

    public static int convertStringToInt(String string) {
        return Integer.parseInt(string);
    }

    public static int getLongestLength(List<String> stringList) {
        return stringList.stream()
                .collect(Collectors.summarizingInt(String::length))
                .getMax();
    }
}
