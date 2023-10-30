package racingcar.utils;

import static racingcar.model.constants.Rule.DELIMITER;

import java.util.Arrays;
import java.util.List;

public class Parser {
    public static List<String> parseCarNames(String inputCarNames) {
        return Arrays.asList(inputCarNames.trim().split(DELIMITER.getMessage()));
    }

    public static int parseTrial(String inputTrial) {
        return Integer.parseInt(inputTrial);
    }
}
