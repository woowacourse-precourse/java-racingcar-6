package racingcar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Converter {
    public static final String DELIMITER = ",";

    public static List<String> delimitCarNames(String carNames) {
        String[] delimitedCarNames = carNames.split(DELIMITER);
        Validator.validateCarNames(delimitedCarNames);
        return new ArrayList<>(Arrays.asList(delimitedCarNames));
    }

    public static int convertAttempts(String attempts) {
        Validator.validateAttemptsNumber(attempts);
        Validator.validateAttemptsRange(attempts);
        return Integer.parseInt(attempts);
    }

    public static String convertDistance(List<String> distance) {
        StringBuilder convertedDistance = new StringBuilder();
        for (int i = 0; i < distance.size(); i++) {
            convertedDistance.append(distance.get(i));
        }
        return convertedDistance.toString();
    }

    public static List<String> convertWinners(List<Car> winners) {
        List<String> convertedWinners = new ArrayList<>();
        for (int i = 0; i < winners.size(); i++) {
            convertedWinners.add(winners.get(i).getName());
        }
        return convertedWinners;
    }
}
