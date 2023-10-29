package racingcar.utils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Parser {
    public static List<String> parseCarNameInput (String input) {
        return Arrays.stream(input.split(",")).collect(Collectors.toList());
    }
}
