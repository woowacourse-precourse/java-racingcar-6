package racingcar.utils;

import java.util.Arrays;
import java.util.List;

public class Parser {
    public static List<String> parseWithComma(String userInput) {
        return Arrays.stream(userInput.split(","))
                .toList();
    }
}
