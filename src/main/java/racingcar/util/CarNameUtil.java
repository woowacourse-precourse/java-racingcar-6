package racingcar.util;

import java.util.Arrays;
import java.util.List;

public class CarNameUtil {
    public static List<String> parseNamesToList(String names) {
        return Arrays.asList(names.replace(" ", "").split(","));
    }
}
