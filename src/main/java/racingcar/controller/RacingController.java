package racingcar.controller;

import java.util.List;
import racingcar.model.Cars;
import racingcar.model.Racing;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingController {
    private final InputView inputView;
    private final OutputView outputView;
    private Racing racing;
    private Cars cars;

    public RacingController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        setting();
    }

    private void setting() {
        List<String> carNames = inputView.askCarNames();
        int tryCount = inputView.askTryCount();
        cars = Cars.fromNames(carNames);
        racing = new Racing(cars, tryCount);
    }
}
