package racingcar.controller;

import racingcar.domain.GameTry;
import racingcar.domain.RacingGame;
import racingcar.domain.Winners;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingController {
    private final InputView inputView;
    private final OutputView outputView;

    public RacingController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void play() {
        RacingGame racingGame = initRacingGame();
        race(racingGame, inputGameTry());
        OutputView.printWinners(new Winners(racingGame.getCars()));
    }

    private static RacingGame initRacingGame() {
        String carNames = InputView.inputCarNames();
        return new RacingGame(carNames);
    }

    private void race(RacingGame racingGame, GameTry targetGameTry) {
        OutputView.printMainMessage();
        while (racingGame.isContinue(targetGameTry.getGameTry())) {
            racingGame.race();
            OutputView.printCarsStatus(racingGame.getCars());
        }
    }

    private static GameTry inputGameTry() {
        return new GameTry(InputView.inputTryNumber());
    }
}
