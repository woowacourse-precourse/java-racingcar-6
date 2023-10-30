package racingcar.model;

import java.util.List;
import java.util.StringJoiner;

public class WinnerCalculator {

    public static String getWinners(List<Car> cars) {
        int maxMoveDistance = getMaxMoveDistance(cars);
        List<String> winnerList = findWinners(cars, maxMoveDistance);
        return convertListToString(winnerList);
    }

    private static int getMaxMoveDistance(List<Car> cars) {
        return cars.stream()
                .mapToInt(Car::getMoveDistance)
                .max()
                .getAsInt();
    }

    private static List<String> findWinners(List<Car> cars, int maxMoveDistance) {
        return cars.stream()
                .filter(car -> car.getMoveDistance() == maxMoveDistance)
                .map(Car::getName)
                .toList();
    }

    private static String convertListToString(List<String> winnerList) {
        StringJoiner finalWinnersJoiner = new StringJoiner(", ");
        for (String winner : winnerList) {
            finalWinnersJoiner.add(winner);
        }
        return finalWinnersJoiner.toString();
    }
}
