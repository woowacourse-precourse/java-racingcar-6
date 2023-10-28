package controller;

import controller.dto.CarNames;
import model.Cars;
import model.TryCount;
import view.InputView;
import view.OutputView;

public class RacingGameController {

    private final OutputView outputView;
    private final InputView inputView;
    private Cars cars;
    private TryCount tryCount;

    public RacingGameController(final OutputView outputView, final InputView inputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        initGame();
    }

    private void initGame() {
        initCars();
        initTryCount();
    }

    private void initCars() {
        outputView.askCarNames();
        CarNames carNames = CarNames.of(inputView.readLine());
        cars = carNames.toCars();
    }

    private void initTryCount() {
        outputView.askTryCount();
        tryCount = TryCount.from(inputView.readLine());
    }
}
