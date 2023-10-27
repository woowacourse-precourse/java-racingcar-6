package racingcar.controller;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.Car;
import racingcar.view.InputView;

public class Controller {
    private final List<Car> cars;

    public Controller() {
        this.cars = new ArrayList<>();
    }

    public void play() {
        String[] carNames = InputView.inputCarName();
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
        int attemptCount = InputView.inputAttemptCount();
        while (attemptCount-- > 0) {
            for (Car car : cars) {
                car.move();
            }
        }
    }
}
