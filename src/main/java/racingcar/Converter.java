package racingcar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Converter {
    private static final String CAR_NAME_DELIMITER = ",";
    private static final String ONE_STEP = "-";

    public static List<String> separateCarNames(String carNames) {
        String[] separatedCarNames = carNames.split(CAR_NAME_DELIMITER);
        Validator.validateCarNames(separatedCarNames);
        return new ArrayList<>(Arrays.asList(separatedCarNames));
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
        for (Car car : winners) {
            convertedWinners.add(car.getName());
        }
        return convertedWinners;
    }

    public static String matchWinnersConvention(List<String> convertedWinners) {
        return String.join(CAR_NAME_DELIMITER, convertedWinners);
    }
}
