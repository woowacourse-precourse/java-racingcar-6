package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Referee {

    private static final int SINGLE = 1;

    public List<Car> decideWinner(List<Car> cars) {
        int maxDistance = findWinnerDistance(cars);
        return cars.stream().filter(car -> car.located() == maxDistance).collect(Collectors.toList());
    }

    private int findWinnerDistance(List<Car> cars) {
        int maxDistance = 0;
        for (int i = 0; i < cars.size(); i++) {
            if (maxDistance < cars.get(i).located()) {
                maxDistance = cars.get(i).located();
            }
        }
        return maxDistance;
    }

    public boolean isNumberOfWinnerTwoOrMore(List<Car> Winner) {
        return Winner.size() > SINGLE;
    }

    public String makeWinnerWithCommas(List<Car> winners) {
        String strWinners;
        strWinners = winners.stream().map(Car::getName).collect(Collectors.joining(","));
        return strWinners;
    }

    public String announceWinner(List<Car> winners) {
        if (isNumberOfWinnerTwoOrMore(winners)) {
            return makeWinnerWithCommas(winners);
        }
        return winners.get(0).getName();
    }
}
