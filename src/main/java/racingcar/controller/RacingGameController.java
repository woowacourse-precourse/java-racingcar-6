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

    private RacingGame initGame() {
        List<String> carNames = inputView.readCarNames();
        Cars cars = createCarsByCarNames(carNames);
        int attemptCount = inputView.readAttemptCount();
        return new RacingGame(cars, attemptCount);
    }

    private void play(RacingGame racingGame) {
        while (!racingGame.isEnd()) {
            racingGame.proceed();
        }
    }

    public void run() {
        RacingGame racingGame = initGame();
        play(racingGame);
    }
}
