package racingcar.controller;

import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.view.InputView;

public class RacingGameController {

    InputView inputView = new InputView();

    private Car createCarByCarName(String carName) {
        return new Car(carName);
    }

    private Cars createCarsByCarNames(List<String> carNames) {
        List<Car> cars = carNames.stream().map(this::createCarByCarName).toList();
        return new Cars(cars);
    }

    public void run() {
        List<String> carNames = inputView.readCarNames();
        Cars cars = createCarsByCarNames(carNames);

    }
}
