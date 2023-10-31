package racingcar.util;

import java.util.Arrays;
import java.util.List;

public class Convertor {
    public static List<String> splitCarNamesByComma(String string) {
        String[] inputArray = string.split(",");
        return Arrays.asList(inputArray);
    }
}
