package racingcar.controller;

import racingcar.model.CarGroup;
import racingcar.model.TryCount;
import racingcar.utils.Movement;
import racingcar.view.InputView;
import racingcar.view.OutputView;


public class RacingController {
    private final InputView inputView;
    private final OutputView outputView;
    private final Movement movement;

    private CarGroup cars;
    private TryCount tryCount;

    public RacingController(InputView inputView, OutputView outputView, Movement movement) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.movement = movement;
    }

    public void run() {
        setRacingGame();
        playGame();
        endGame();
    }

    private void setRacingGame() {
        cars = new CarGroup(inputView.inputCarNames());
        tryCount = new TryCount(inputView.inputTryCount());
    }

    private void playGame() {
        outputView.printRaceResultHeader();
        while (tryCount.isAbleTry()) {
            cars.race(movement);
            tryCount.decrease();
            outputView.printRacingResult(cars.toDto());
        }
    }

    private void endGame() {
        outputView.printWinCarNames(cars.findWinnerNames());
    }

}
