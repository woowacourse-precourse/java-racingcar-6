package racingcar.util;

import static java.util.Arrays.asList;

import java.util.List;

public class NameHandler {
    public static List<String> splitNames(String in) {
        return asList(in.split(",", -1));
    }
}
