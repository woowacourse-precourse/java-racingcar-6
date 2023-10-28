package racingcar.core;

import racingcar.domain.Car;

import java.util.ArrayList;
import java.util.List;

public class WinnerCheckSystem {
    private int MAX_LINE;
    private List<Car> winners = new ArrayList<>();

    public void setMaxLine(final int line) {
        this.MAX_LINE = line;
    }

    public List<Car> check(List<Car> cars) {
        for (Car car : cars) {
            if (car.getCurrentStep() >= MAX_LINE) {
                winners.add(car);
            }
        }
        return winners;
    }

    public List<Car> getWinners() {
        return winners;
    }
}
