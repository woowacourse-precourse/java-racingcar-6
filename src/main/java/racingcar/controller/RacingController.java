package racingcar.controller;

import racingcar.model.Cars;
import racingcar.model.PlayRacing;
import racingcar.model.TryCount;
import racingcar.util.RandomNumberGenerator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingController {

    private final InputView inputView;
    private final OutputView outputView;
    private PlayRacing playRacing;

    public RacingController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void start() {
        Cars cars = initCars();
        TryCount tryCount = initTryCount();

        playRacing = new PlayRacing(new RandomNumberGenerator(), cars);
        outputView.printRacingResult();
        inProgress(tryCount);
        outputView.printWinner(playRacing.end());
    }

    private void inProgress(TryCount tryCount) {
        for (int i = 0; i < tryCount.getTryCount(); i++) {
            ;
            outputView.printProcess(playRacing.process());
        }
    }

    private TryCount initTryCount() {
        System.out.println();
        outputView.printTryCountMessage();
        return new TryCount(inputView.inputTryCount());
    }

    private Cars initCars() {
        outputView.printStartMessage();
        return new Cars(inputView.inputCarNames());
    }
}
