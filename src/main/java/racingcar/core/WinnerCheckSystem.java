package racingcar.core;

import racingcar.domain.Car;

import java.util.ArrayList;
import java.util.List;

public class WinnerCheckSystem {
    private List<Car> winners = new ArrayList<>();

    public List<Car> getWinners(List<Car> cars) {
        int maxLine = maxLineCount(cars);
        for (Car car : cars) {
            if (car.getCurrentStep() == maxLine) {
                winners.add(car);
            }
        }
        return winners;
    }

    public static int maxLineCount(List<Car> cars){
        int maxLine = 0;
        for (Car car : cars) {
            maxLine = Math.max(maxLine, car.getCurrentStep());
        }

        return maxLine;
    }
}
