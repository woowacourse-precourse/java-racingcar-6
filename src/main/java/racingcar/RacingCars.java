package racingcar;

import java.util.ArrayList;
import java.util.List;

public class RacingCars {
    private List<Car> cars;

    public RacingCars(List<Car> carList) {
        cars = carList;
    }

    public List<String> getWinner() {
        int maxPosition = getMaxPosition();
        List<String> winners = new ArrayList<>();
        for (Car car : cars) {
            if (car.getPosition() == maxPosition) {
                winners.add(car.getCarName());
            }
        }
        return winners;
    }

    private int getMaxPosition() {
        int maxPosition = 0;
        for (Car car : cars) {
            if (car.getPosition() > maxPosition) {
                maxPosition = car.getPosition();
            }
        }
        return maxPosition;
    }

    public List<Car> getRacingCars() {
        return cars;
    }
}
