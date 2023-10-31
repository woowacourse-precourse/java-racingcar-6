package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class Winner {

    private List<String> winnerName;

    public List<String> getWinnerName() {
        return winnerName;
    }

    public List<String> findWinnerName(List<Car> cars) {
        winnerName = new ArrayList<>();
        int maxForwardDistance = maxDistance(cars);
        winnerCarName(maxForwardDistance, cars);
        return winnerName;
    }

    private int maxDistance(List<Car> cars) {
        int max = 0;
        for (Car car : cars) {
            max = Math.max(car.getPosition(), max);
        }
        return max;
    }

    private void winnerCarName(int max, List<Car> cars) {
        for (Car car : cars) {
            if (car.getPosition() == max) {
                winnerName.add(car.getCarName());
            }
        }
    }
}
