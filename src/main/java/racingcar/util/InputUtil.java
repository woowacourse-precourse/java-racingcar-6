package racingcar.util;

import java.util.Arrays;
import java.util.List;

public class InputUtil {

    private InputUtil() {

    }

    public static List<String> convertInputStringToList(String input) {
        return Arrays.stream(input.split(","))
                .toList();
    }
}