package racingcar.input;

import java.util.List;

public class InputParser {
    public static List<String> parseCarNames(String input) {
        return List.of(input.split(","));
    }
}
