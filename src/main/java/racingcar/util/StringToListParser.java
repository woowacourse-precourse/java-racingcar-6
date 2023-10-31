package racingcar.util;

import java.util.Arrays;
import java.util.List;

public class StringToListParser {
    public static List<String> parseToList(String string, String delimiter) {
        return Arrays.stream(string.split(delimiter)).toList();
    }
}
