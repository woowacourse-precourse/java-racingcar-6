package racingcar;

import java.util.ArrayList;
import java.util.List;

public class CarRace {

    private List<Car> cars = new ArrayList<>();

    public CarRace(List<String> carNames) {
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
    }

    public void race() {
        for (Car car : cars) {
            car.run();
        }
    }
    public List<String> findWinners() {
        List<String> winners = new ArrayList<>();
        int maxPosition = 0;

        for (Car car : cars) {
            if (car.getPositionLength() > maxPosition) {
                maxPosition = car.getPositionLength();
                winners.clear();
                winners.add(car.getName());
            } else if (car.getPositionLength() == maxPosition) {
                winners.add(car.getName());
            }
        }

        return winners;
    }

}
