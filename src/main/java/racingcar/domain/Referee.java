package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Referee {
    private List<Car> cars;

    public Referee(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> judgeWinners() {
        List<Car> winners = new ArrayList<>();
        int maxLocation = Integer.MIN_VALUE;

        for (Car car : cars) {
            int location = car.getLocation();
            if (location > maxLocation) {
                maxLocation = location;
                winners.clear();
                winners.add(car);
            } else if (location == maxLocation) {
                winners.add(car);
            }
        }
        return winners;
    }
}
