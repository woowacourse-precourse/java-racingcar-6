package racingcar.utils;

import java.util.Arrays;
import java.util.List;

public class Converter {
    private Converter() {}

    public static List<String> convertInputToArray(String input) {
        return Arrays.stream(input.split(","))
                .map(String::trim)
                .toList();
    }
}
