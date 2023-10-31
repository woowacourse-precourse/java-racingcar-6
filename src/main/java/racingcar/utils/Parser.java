package racingcar.utils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Parser {

    public static final String COMMA = ",";
    public static final int MAX_LENGTH_NUMBER = 5;

    public static List<String> parseCarNameInput (String input) {
        List<String> nameList = Arrays.stream(input.split(COMMA)).collect(Collectors.toList());
        for (String s : nameList) {
            String trimmed = s.trim();
            if (s.length() > MAX_LENGTH_NUMBER || trimmed.isEmpty() || s.isEmpty() || s.equals("\n") || s.equals("\r") || s.equals("\r\n")) {
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
