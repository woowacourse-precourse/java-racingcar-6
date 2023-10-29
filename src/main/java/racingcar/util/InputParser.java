package racingcar.util;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class InputParser {
    private static final int INITIAL_COUNT_VALUE = 0;

    public static List<String> parseCarNameList(String input) {
        return Arrays.stream(input.split(","))
                .collect(Collectors.toList());
    }

    public static Map<String, Integer> parseCarMap(String input) {
        return Arrays.stream(input.split(","))
                .collect(Collectors.toMap(
                        key -> key,
                        value -> INITIAL_COUNT_VALUE,
                        (exitingValue, newValue) -> exitingValue,
                        HashMap::new
                ));
    }

    public static int parseTrialCountToInt(String input) {
        return Integer.parseInt(input);
    }
}
