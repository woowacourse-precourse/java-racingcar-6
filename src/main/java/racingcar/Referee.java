package racingcar;

import java.util.List;

public class Referee {
    public int findMaxDistance(List<Car> carList) {
        int max = 0;
        for (Car car : carList) {
            int distance = car.getDistance();
            if (distance > max) {
                max = distance;
            }
        }

        return max;
    }

    public List<Car> findWinner(List<Car> carList, int max) {
        return null;
    }
}
