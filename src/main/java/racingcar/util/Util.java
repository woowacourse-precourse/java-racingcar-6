package racingcar.util;

import java.util.Arrays;
import java.util.List;

public class Util {
    public static List<String> splitNameByComma(String names) {
        List<String> splits = Arrays.stream(names.split(",")).toList();
        return splits;
    }

    public static int convertStringToInt(String count) {
        int convert = Integer.parseInt(count);
        return convert;
    }
}
