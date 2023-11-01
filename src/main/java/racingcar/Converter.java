package racingcar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Converter {
    public static final String DELIMITER = ",";
    public static final String ONE_STEP = "-";

    public static List<String> delimitCarNames(String carNames) {
        String[] delimitedCarNames = carNames.split(DELIMITER);
        Validator.validateCarNames(delimitedCarNames);
        return new ArrayList<>(Arrays.asList(delimitedCarNames));
    }

    public static int convertRound(String round) {
        Validator.validateRoundNumber(round);
        Validator.validateRoundRange(round);
        return Integer.parseInt(round);
    }

    public static String convertDistance(int distance) {
        return ONE_STEP.repeat(Math.max(0, distance));
    }

    public static List<String> convertWinners(List<Car> winners) {
        List<String> convertedWinners = new ArrayList<>();
        for (Car winner : winners) {
            convertedWinners.add(winner.getName());
        }
        return convertedWinners;
    }

    public static String matchWinnersConvention(List<String> convertedWinners) {
        return String.join(DELIMITER, convertedWinners);
    }
}
