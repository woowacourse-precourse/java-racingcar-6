package racingcar.utils;

import java.util.Arrays;
import java.util.List;

public class Utils {

    public static List<String> parseNames(String input) {
        return Arrays.asList(input.split(","));
    }
}
