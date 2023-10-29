package racingcar.model;

import java.util.List;
import java.util.StringJoiner;

public class WinnerCalculator {

    public String getWinners(List<Car> cars) {
        int maxMoveDistance = getMaxMoveDistance(cars);
        List<String> winnerList = findWinners(cars, maxMoveDistance);
        return convertListToString(winnerList);
    }

    private int getMaxMoveDistance(List<Car> cars) {
        return cars.stream()
                .mapToInt(Car::getMoveDistance)
                .max()
                .getAsInt();
    }

    private List<String> findWinners(List<Car> cars, int maxMoveDistance) {
        return cars.stream()
                .filter(racingCar -> racingCar.getMoveDistance() == maxMoveDistance)
                .map(Car::getName)
                .toList();
    }

    private String convertListToString(List<String> winnerList) {
        StringJoiner finalWinnersJoiner = new StringJoiner(", ");
        for (String winner : winnerList) {
            finalWinnersJoiner.add(winner);
        }
        return finalWinnersJoiner.toString();
    }
}
