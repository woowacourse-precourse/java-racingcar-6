package racingcar.model;

import racingcar.view.JudgeView;

import java.util.ArrayList;
import java.util.List;

public class Judge {

    public static void determineWinners(List<Car> cars) {
        List<Car> winners = new ArrayList<>();

        for (Car car : cars) {
            if (car.getPosition() == getMaxPosition(cars)) {
                winners.add(car);
            }
        }
        JudgeView.printWinners(winners);
    }

    private static int getMaxPosition(List<Car> cars) {
        int maxPosition = Integer.MIN_VALUE;

        for (Car car : cars) {
            maxPosition = Math.max(maxPosition, car.getPosition());
        }
        return maxPosition;
    }

}
