package racingcar.Util;

import java.util.Arrays;
import java.util.List;

public class NameUtil {
    public static List<String> splitName(String carsName) {
        return Arrays.asList(carsName.split(","));
    }
}