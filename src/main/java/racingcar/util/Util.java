package racingcar.util;

import java.util.Arrays;
import java.util.List;

public class Util {
    public static List<String> parseNamesToList(String names) {
        return Arrays.asList(names.replace(" ", "").split(","));
    }
}
