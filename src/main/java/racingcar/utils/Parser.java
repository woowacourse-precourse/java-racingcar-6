package racingcar.utils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Parser {
    public static List<String> parseCarNameInput (String input) {
        List<String> nameList = Arrays.stream(input.split(",")).collect(Collectors.toList());
        for (String s : nameList) {
            if (s.length() > 5) {
                throw new IllegalArgumentException();
            }
        }
        return nameList;
    }

    public static int parseTryTimesInput(String input) {
        if (!input.matches("^\\d+$")) {
            throw new IllegalArgumentException();
        }
        return Integer.parseInt(input);
    }
}
