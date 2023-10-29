package racingcar.controller;

import racingcar.model.CarGroup;
import racingcar.model.RacingGame;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class RacingController {
    private final InputView inputView;
    private final OutputView outputView;

    public RacingController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        RacingGame racingGame = setRacingGame();
        playGame(racingGame);
        endGame(racingGame);
    }

    private RacingGame setRacingGame() {
        List<String> names = inputView.inputCarNames();
        Integer tryCount = inputView.inputTryCount();
        return new RacingGame(names, tryCount);
    }

    private void playGame(RacingGame racingGame) {
        outputView.printRaceResultHeader();
        while (racingGame.isPlayable()) {
            racingGame.start();
            CarGroup cars = racingGame.getCars();
            outputView.printRacingResult(cars.toDto());
        }
    }

    private void endGame(RacingGame racingGame) {
        outputView.printWinCarNames(racingGame.findWinCars());
    }

}
