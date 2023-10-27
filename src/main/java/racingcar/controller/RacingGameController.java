package racingcar.controller;

import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.RacingGame;
import racingcar.view.InputView;

public class RacingGameController {

    InputView inputView = new InputView();

    private Cars createCarsByCarNames(List<String> carNames) {
        List<Car> cars = carNames.stream().map(Car::new).toList();
        return new Cars(cars);
    }

    public void run() {
        List<String> carNames = inputView.readCarNames();
        Cars cars = createCarsByCarNames(carNames);
        int attemptCount = inputView.readAttemptCount();
        RacingGame racingGame = new RacingGame(cars, attemptCount);

    }
}
