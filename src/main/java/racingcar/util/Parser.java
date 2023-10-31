package racingcar.util;

import java.util.Arrays;
import java.util.List;

public class Parser {
    public int parseStringToInt(String input) throws IllegalArgumentException{
        return Integer.parseInt(input);
    }

    public List<String> parseCarNames(String input) {
        return Arrays.asList(input.split(","));
    }
}
