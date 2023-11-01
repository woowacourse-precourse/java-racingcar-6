package racingcar;

import java.util.ArrayList;
import java.util.List;

public class FindWinners {
    public List<Car> getWinners(List<Car> cars) {
        List<Car> winners = new ArrayList<>();
        int maxPosition = getMaxPostion(cars);

        for (Car car : cars) {
            if (car.getPosition() == maxPosition) {
                winners.add(car);
            }
        }
        return winners;
    }

    private int getMaxPostion(List<Car> cars) {
        int max = 0;
        for(Car car : cars) {
            if(car.getPosition() > max) {
                max = car.getPosition();
            }
        }
        return max;
    }
}
