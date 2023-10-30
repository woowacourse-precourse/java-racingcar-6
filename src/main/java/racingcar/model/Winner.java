package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class Winner {

    private List<String> winnerName;

    public List<String> getWinnerName() {
        return winnerName;
    }

    public void findWinnerName(List<Car> cars) {
        winnerName = new ArrayList<>();
        int maxForwardDistance = maxDistance(cars);
    }

    private int maxDistance(List<Car> cars){
        int max = 0;
        for (Car car : cars) {
            max = Math.max(car.getPosition(),max);
        }
        return max;
    }
}
