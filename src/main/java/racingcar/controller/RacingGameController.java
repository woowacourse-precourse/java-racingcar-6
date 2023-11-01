package racingcar.controller;

import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.RandomMovingCar;
import racingcar.domain.Cars;
import racingcar.domain.RacingGame;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingGameController {
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();

    private Car createRandomMovingCar(String carName) {
        return new RandomMovingCar(carName);
    }

    private Cars createGameCarsByCarNames(List<String> carNames) {
        List<Car> gameCars = carNames.stream()
                .map(this::createRandomMovingCar)
                .toList();

        return new Cars(gameCars);
    }

    private RacingGame initRacingGame() {
        List<String> carNames = inputView.readCarNames();
        Cars cars = createGameCarsByCarNames(carNames);
        int attemptCount = inputView.readAttemptCount();

        return new RacingGame(cars, attemptCount);
    }

    private void play(RacingGame racingGame) {
        outputView.printGameResultMessage();
        while (!racingGame.isEnd()) {
            racingGame.proceed();
            outputView.printGameState(racingGame.getCurrentState());
        }
        outputView.printWinners(racingGame.getCurrentState());
    }

    public void run() {
        RacingGame racingGame = initRacingGame();
        play(racingGame);
    }
}
