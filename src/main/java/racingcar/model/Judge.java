package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class Judge {

    public static List<Car> determineWinners(List<Car> cars) {
        List<Car> winners = new ArrayList<>();

        for (Car car : cars) {
            if (car.getPosition() == getMaxPosition(cars)) {
                winners.add(car);
            }
        }
        return winners;
    }

    private static int getMaxPosition(List<Car> cars) {
        int maxPosition = Integer.MIN_VALUE;

        for (Car car : cars) {
            maxPosition = Math.max(maxPosition, car.getPosition());
        }
        return maxPosition;
    }

}
