package racingcar.game;

import java.util.ArrayList;
import java.util.List;
import racingcar.car.Car;

public class RacingCarGame {

    private List<Car> cars;

    public void play(List<String> carNames, int attemptCount) {
        makeCars(carNames);
    }

    private void makeCars(List<String> carNames) {
        cars = new ArrayList<>();
        for (String carName : carNames) {
            cars.add(Car.of(carName));
        }
    }

}
