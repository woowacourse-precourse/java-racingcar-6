package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Referee {
    public List<Car> getWinner(List<Car> cars, int goalPosition) {
        List<Car> winners = new ArrayList<>();
        for (Car car : cars) {
            if (car.getPosition() == goalPosition) {
                winners.add(car);
            }
        }
        return winners;
    }

    public boolean isWinner(List<Car> cars, int goalPosition) {
        for (Car car : cars) {
            if (car.getPosition() == goalPosition) {
                return true;
            }
        }
        return false;
    }
}
