package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class WinnerDeterminer {
    public List<String> determineWinners(List<Car> cars) {
        int maxPosition = getMaxPosition(cars);
        List<String> winners = new ArrayList<>();

        for (Car car : cars) {
            if(car.getPosition() == maxPosition) {
                winners.add(car.getCarName());
            }
        }

        return winners;
    }   

    private int getMaxPosition(List<Car> cars) {
        int maxPosition = 0;

        for (Car car : cars) {
            int currentPositon = car.getPosition();
            maxPosition = Math.max(maxPosition, currentPositon);
        }

        return maxPosition;
    }
}
