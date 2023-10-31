package racingcar.utils;

import java.util.Arrays;
import java.util.List;

public class Parser {

    private static final String SPLIT_REGEX = ",";

    public List<String> parseCarNameInput(String userInput) {
        return Arrays.asList(userInput.split(SPLIT_REGEX));
    }

    public int parseAttemptCountInput(String userInput) {
        return Integer.parseInt(userInput);
    }
}
