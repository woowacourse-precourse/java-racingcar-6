package racingcar.utils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Utils {

    public static List<String> parseNames(String input) {
        String[] parseArray = input.split(",");
        return Arrays.stream(parseArray).
                collect(Collectors.toList());
    }
}
