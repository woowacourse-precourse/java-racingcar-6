package racingcar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Converter {
    static final String SEPARATOR = ",";

    public static List<String> separateCarNames(String carNames) {
        String[] separatedCarNames = carNames.split(SEPARATOR);
        Validator.validateCarNames(separatedCarNames);
        return new ArrayList<>(Arrays.asList(separatedCarNames));
    }

    public static int convertAttempts(String attempts) {
        Validator.validateAttemptsNumber(attempts);
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
