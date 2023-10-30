package racingcar.input;

import java.util.List;

public class InputParser {

    public List<String> getParsed(String input) {
        String[] parsed = input.split(",");
        return List.of(parsed);
    }
}
