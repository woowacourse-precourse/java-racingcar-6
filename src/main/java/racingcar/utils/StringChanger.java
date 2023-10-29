package racingcar.utils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringChanger {
    public static List<String> stringToStringList(String string) {
        return Arrays.stream(string.split(",", -1))
                .map(String::trim).collect(Collectors.toList());
    }
}
