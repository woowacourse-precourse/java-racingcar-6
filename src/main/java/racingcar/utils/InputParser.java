package racingcar.utils;

import java.util.Arrays;
import java.util.List;

public class InputParser {

    public static List<String> parseCarNames(String input) {
        return Arrays.asList(input.split(","));
    }

}
