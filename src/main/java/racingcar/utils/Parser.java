package racingcar.utils;

import static racingcar.model.constants.Phrase.DELIMITER;

import java.util.List;

public class Parser {
    public static List<String> parseCarNames(String inputCarNames) {
        return List.of(inputCarNames.trim().split(DELIMITER.getMessage()));
    }

    public static int parseTrial(String inputTrial) {
        return Integer.parseInt(inputTrial);
    }
}
