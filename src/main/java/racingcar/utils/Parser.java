package racingcar.utils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Parser {

    private Parser() {
        throw new AssertionError();
    }

    public static List<String> stringToList(String string) {
        return Arrays.stream(string.split(","))
                .map(String::trim)
                .collect(Collectors.toList());
    }
}
