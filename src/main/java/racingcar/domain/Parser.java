package racingcar.domain;

public class Parser {

    public static String[] parseCarNames(String carNames) {
        return carNames.split(",");
    }

    public static int parseRacingRoundCount(String roundCount) {
        return Integer.parseInt(roundCount);
    }
}
