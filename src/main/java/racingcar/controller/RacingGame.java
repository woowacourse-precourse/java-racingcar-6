package racingcar.controller;

import racingcar.model.car.CarManager;
import racingcar.model.car.Movable;
import racingcar.model.car.RandomMovable;
import racingcar.model.cycle.RaceCount;
import racingcar.model.race.Racing;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingGame {

    private final InputView inputView;
    private final OutputView outputView;

    public RacingGame(final InputView inputView, final OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void start() {
        final Racing racing = this.enterCarNamesAndRacingCount();

        outputView.printResultMessage();
        racing.start(outputView::printSingleRaceResult);
        racing.getWinner(outputView::printFinalRaceResult);
    }

    private Racing enterCarNamesAndRacingCount() {
        final CarManager carManager = new CarManager(inputView.enterCarNames());
        final RaceCount raceCount = new RaceCount(inputView.enterRacingCount());

        return new Racing(carManager, raceCount, new RandomMovable());
    }
}
