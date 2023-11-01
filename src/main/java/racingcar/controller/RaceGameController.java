package racingcar.controller;

import racingcar.model.RacingCars;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class RaceGameController {
    private final InputView inputView;
    private final OutputView outputView;

    public RaceGameController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void startGame() {
        RacingCars racingCars = initializeGame();

    }

    private RacingCars initializeGame() {
        outputView.printStartMessage();
        List<String> carNames = inputView.inputNamesStringToList();
        return new RacingCars(carNames);
    }
}
