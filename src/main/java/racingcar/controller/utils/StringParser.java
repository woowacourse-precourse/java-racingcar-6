package racingcar.controller.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringParser {
    public List<String> splitCarNames(String input) {
        return new ArrayList<>(Arrays.asList(input.split(",")));
    }

    public static int toInteger(String input) {
        return Integer.parseInt(input);
    }
}
