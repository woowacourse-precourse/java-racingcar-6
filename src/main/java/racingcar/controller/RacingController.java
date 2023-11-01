package racingcar.controller;

import java.util.List;
import racingcar.model.Cars;
import racingcar.model.RacingManager;
import racingcar.model.RacingResult;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingController {
    private final InputView inputView;
    private final OutputView outputView;
    private Cars cars;
    private RacingManager racingManager;
    private RacingResult racingResult;

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
        this.cars = Cars.fromNames(carNames);
        this.racingManager = new RacingManager(tryCount);
    }
}
