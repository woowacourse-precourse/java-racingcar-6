package racingcar.util;

import java.util.Arrays;
import java.util.List;

public class InputParser {
    private static final String DELIMITER = ",";

    public List<String> parseCarName(String playerInput) {
        return Arrays.stream(playerInput.split(DELIMITER)).toList();
    }

    public int parseNumberOfAttempt(String playerInput) {
        return Integer.parseInt(playerInput);
    }
}
