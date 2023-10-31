package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Referee {

    public static List<Car> separationWinners(List<Car> carList) {
        List<Car> winners = new ArrayList<>();
        int maxPosition = checkMaxPosition(carList);
        for (Car car : carList) {
            if (car.getPosition() == maxPosition) {
                winners.add(car);
            }
        }
        return winners;
    }

    public static int checkMaxPosition(List<Car> carList) {
        int maxPosition = 0;
        for (Car car : carList) {
            if (maxPosition < car.getPosition()) {
                maxPosition = car.getPosition();
            }
        }
        return maxPosition;
    }

}
