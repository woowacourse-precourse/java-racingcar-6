package racingcar.controller;

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
        final String carNames = inputView.enterCarNames();
        final String racingCount = inputView.enterRacingCount();

        return new Racing(carNames, racingCount);
    }
}
