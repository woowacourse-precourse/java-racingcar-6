package racingcar.controller;

import java.util.List;
import racingcar.domain.Cars;
import racingcar.domain.GameCar;
import racingcar.domain.GameCars;
import racingcar.domain.RacingGame;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingGameController {
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();

    private Cars createCarsByCarNames(List<String> carNames) {
        List<GameCar> gameCars = carNames.stream()
                .map(GameCar::new)
                .toList();

        return new GameCars(gameCars);
    }

    private RacingGame initGame() {
        List<String> carNames = inputView.readCarNames();
        Cars cars = createCarsByCarNames(carNames);
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
        RacingGame racingGame = initGame();
        play(racingGame);
    }
}
