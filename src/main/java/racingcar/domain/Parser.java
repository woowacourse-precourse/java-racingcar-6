package racingcar.domain;

import java.util.List;

public class Parser {

    public static List<String> parseCarNames(String carNames) {
        return List.of(carNames.split(","));
    }

    public static int parseRacingRoundCount(String roundCount) {
        return Integer.parseInt(roundCount);
    }
}
