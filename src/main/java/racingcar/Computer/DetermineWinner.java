package racingcar.Computer;

import java.util.List;
import java.util.ArrayList;
import racingcar.Car.Car;

public class DetermineWinner {

    public List<Car> getWinners(List<Car> cars) {
        List<Car> winners = new ArrayList<>();

        int maxPosition = findMaxPosition(cars);

        for (Car car : cars) {
            if (car.getCurrentPosition() == maxPosition) {
                winners.add(car);
            }
        }

        return winners;
    }

    private int findMaxPosition(List<Car> cars) {
        int max = Integer.MIN_VALUE;

        for (Car car : cars) {
            if (car.getCurrentPosition() > max) {
                max = car.getCurrentPosition();
            }
        }

        return max;
    }

}