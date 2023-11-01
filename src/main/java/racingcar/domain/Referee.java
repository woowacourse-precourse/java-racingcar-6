package racingcar.domain;

import java.util.List;

public class Referee {

    public Winners findWinners(List<Car> cars) {
        Winners winners = new Winners();

        int locationOfWinner = findLocationOfWinner(cars);
        for (Car car : cars) {
            if (car.getLastLocation() == locationOfWinner) {
                car.addToWinner(winners);
            }
        }
        return winners;
    }

    private int findLocationOfWinner(List<Car> cars) {
        int maxArrivalPoint = 0;

        for (Car car : cars) {
            maxArrivalPoint = Math.max(maxArrivalPoint, car.getLastLocation());
        }

        return maxArrivalPoint;
    }
}
