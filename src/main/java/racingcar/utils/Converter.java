package racingcar.utils;

import java.util.Arrays;
import java.util.List;

public class Converter {
    public static List<String> convertStringToList (String input) {
        return Arrays.stream(input.split(",")).toList();
    }
}
