package racingcar.utils;

import java.util.Arrays;
import java.util.List;

public class StringSplitter {
    public static List<String> split(String input, String delimiter) {
        return Arrays.asList(input.split(delimiter));
    }
}
