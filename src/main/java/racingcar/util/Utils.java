package racingcar.util;

import java.util.Arrays;
import java.util.List;

public class Utils {
    public static List<String> toList(String carNames) {
        return Arrays.asList(carNames.split("\\s*,\\s*", -1));
    }
}
